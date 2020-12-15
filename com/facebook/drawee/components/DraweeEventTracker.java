package com.facebook.drawee.components;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
/* loaded from: classes8.dex */
public class DraweeEventTracker {
    private final Queue<Event> pep = new ArrayBlockingQueue(20);
    private static final DraweeEventTracker peq = new DraweeEventTracker();
    private static boolean oEI = true;

    /* loaded from: classes8.dex */
    public enum Event {
        ON_SET_HIERARCHY,
        ON_CLEAR_HIERARCHY,
        ON_SET_CONTROLLER,
        ON_CLEAR_OLD_CONTROLLER,
        ON_CLEAR_CONTROLLER,
        ON_INIT_CONTROLLER,
        ON_ATTACH_CONTROLLER,
        ON_DETACH_CONTROLLER,
        ON_RELEASE_CONTROLLER,
        ON_DATASOURCE_SUBMIT,
        ON_DATASOURCE_RESULT,
        ON_DATASOURCE_RESULT_INT,
        ON_DATASOURCE_FAILURE,
        ON_DATASOURCE_FAILURE_INT,
        ON_HOLDER_ATTACH,
        ON_HOLDER_DETACH,
        ON_DRAWABLE_SHOW,
        ON_DRAWABLE_HIDE,
        ON_ACTIVITY_START,
        ON_ACTIVITY_STOP,
        ON_RUN_CLEAR_CONTROLLER,
        ON_SCHEDULE_CLEAR_CONTROLLER,
        ON_SAME_CONTROLLER_SKIPPED,
        ON_SUBMIT_CACHE_HIT
    }

    private DraweeEventTracker() {
    }

    public static DraweeEventTracker erc() {
        return oEI ? new DraweeEventTracker() : peq;
    }

    public void a(Event event) {
        if (oEI) {
            if (this.pep.size() + 1 > 20) {
                this.pep.poll();
            }
            this.pep.add(event);
        }
    }

    public String toString() {
        return this.pep.toString();
    }
}
