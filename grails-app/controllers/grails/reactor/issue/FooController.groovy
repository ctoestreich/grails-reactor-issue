package grails.reactor.issue

import grails.async.Promise
import org.grails.async.factory.reactor.ReactorPromise

import static grails.async.Promises.task

class FooController {

    def index() {
        ReactorPromise<String> fooPromise = (ReactorPromise)task {
            34.times {
                sleep 1000
                println 'in loop ' + it
            }
            println 'I Love Grails is being returned now'
            return "I Love Grails"
        }

        String foo = fooPromise.get()

        render view: '/index', model: [foo: foo]
    }
}
