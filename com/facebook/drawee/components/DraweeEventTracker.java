package com.facebook.drawee.components;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
/* loaded from: classes2.dex */
public class DraweeEventTracker {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_EVENTS_TO_TRACK = 20;
    public static boolean sEnabled;
    public static final DraweeEventTracker sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public final Queue<Event> mEventQueue;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class Event {
        public static final /* synthetic */ Event[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Event ON_ACTIVITY_START;
        public static final Event ON_ACTIVITY_STOP;
        public static final Event ON_ATTACH_CONTROLLER;
        public static final Event ON_CLEAR_CONTROLLER;
        public static final Event ON_CLEAR_HIERARCHY;
        public static final Event ON_CLEAR_OLD_CONTROLLER;
        public static final Event ON_DATASOURCE_FAILURE;
        public static final Event ON_DATASOURCE_FAILURE_INT;
        public static final Event ON_DATASOURCE_RESULT;
        public static final Event ON_DATASOURCE_RESULT_INT;
        public static final Event ON_DATASOURCE_SUBMIT;
        public static final Event ON_DETACH_CONTROLLER;
        public static final Event ON_DRAWABLE_HIDE;
        public static final Event ON_DRAWABLE_SHOW;
        public static final Event ON_HOLDER_ATTACH;
        public static final Event ON_HOLDER_DETACH;
        public static final Event ON_INIT_CONTROLLER;
        public static final Event ON_RELEASE_CONTROLLER;
        public static final Event ON_RUN_CLEAR_CONTROLLER;
        public static final Event ON_SAME_CONTROLLER_SKIPPED;
        public static final Event ON_SCHEDULE_CLEAR_CONTROLLER;
        public static final Event ON_SET_CONTROLLER;
        public static final Event ON_SET_HIERARCHY;
        public static final Event ON_SUBMIT_CACHE_HIT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-498703258, "Lcom/facebook/drawee/components/DraweeEventTracker$Event;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-498703258, "Lcom/facebook/drawee/components/DraweeEventTracker$Event;");
                    return;
                }
            }
            ON_SET_HIERARCHY = new Event("ON_SET_HIERARCHY", 0);
            ON_CLEAR_HIERARCHY = new Event("ON_CLEAR_HIERARCHY", 1);
            ON_SET_CONTROLLER = new Event("ON_SET_CONTROLLER", 2);
            ON_CLEAR_OLD_CONTROLLER = new Event("ON_CLEAR_OLD_CONTROLLER", 3);
            ON_CLEAR_CONTROLLER = new Event("ON_CLEAR_CONTROLLER", 4);
            ON_INIT_CONTROLLER = new Event("ON_INIT_CONTROLLER", 5);
            ON_ATTACH_CONTROLLER = new Event("ON_ATTACH_CONTROLLER", 6);
            ON_DETACH_CONTROLLER = new Event("ON_DETACH_CONTROLLER", 7);
            ON_RELEASE_CONTROLLER = new Event("ON_RELEASE_CONTROLLER", 8);
            ON_DATASOURCE_SUBMIT = new Event("ON_DATASOURCE_SUBMIT", 9);
            ON_DATASOURCE_RESULT = new Event("ON_DATASOURCE_RESULT", 10);
            ON_DATASOURCE_RESULT_INT = new Event("ON_DATASOURCE_RESULT_INT", 11);
            ON_DATASOURCE_FAILURE = new Event("ON_DATASOURCE_FAILURE", 12);
            ON_DATASOURCE_FAILURE_INT = new Event("ON_DATASOURCE_FAILURE_INT", 13);
            ON_HOLDER_ATTACH = new Event("ON_HOLDER_ATTACH", 14);
            ON_HOLDER_DETACH = new Event("ON_HOLDER_DETACH", 15);
            ON_DRAWABLE_SHOW = new Event("ON_DRAWABLE_SHOW", 16);
            ON_DRAWABLE_HIDE = new Event("ON_DRAWABLE_HIDE", 17);
            ON_ACTIVITY_START = new Event("ON_ACTIVITY_START", 18);
            ON_ACTIVITY_STOP = new Event("ON_ACTIVITY_STOP", 19);
            ON_RUN_CLEAR_CONTROLLER = new Event("ON_RUN_CLEAR_CONTROLLER", 20);
            ON_SCHEDULE_CLEAR_CONTROLLER = new Event("ON_SCHEDULE_CLEAR_CONTROLLER", 21);
            ON_SAME_CONTROLLER_SKIPPED = new Event("ON_SAME_CONTROLLER_SKIPPED", 22);
            Event event = new Event("ON_SUBMIT_CACHE_HIT", 23);
            ON_SUBMIT_CACHE_HIT = event;
            $VALUES = new Event[]{ON_SET_HIERARCHY, ON_CLEAR_HIERARCHY, ON_SET_CONTROLLER, ON_CLEAR_OLD_CONTROLLER, ON_CLEAR_CONTROLLER, ON_INIT_CONTROLLER, ON_ATTACH_CONTROLLER, ON_DETACH_CONTROLLER, ON_RELEASE_CONTROLLER, ON_DATASOURCE_SUBMIT, ON_DATASOURCE_RESULT, ON_DATASOURCE_RESULT_INT, ON_DATASOURCE_FAILURE, ON_DATASOURCE_FAILURE_INT, ON_HOLDER_ATTACH, ON_HOLDER_DETACH, ON_DRAWABLE_SHOW, ON_DRAWABLE_HIDE, ON_ACTIVITY_START, ON_ACTIVITY_STOP, ON_RUN_CLEAR_CONTROLLER, ON_SCHEDULE_CLEAR_CONTROLLER, ON_SAME_CONTROLLER_SKIPPED, event};
        }

        public Event(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Event valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Event) Enum.valueOf(Event.class, str) : (Event) invokeL.objValue;
        }

        public static Event[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Event[]) $VALUES.clone() : (Event[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1361332028, "Lcom/facebook/drawee/components/DraweeEventTracker;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1361332028, "Lcom/facebook/drawee/components/DraweeEventTracker;");
                return;
            }
        }
        sInstance = new DraweeEventTracker();
        sEnabled = true;
    }

    public DraweeEventTracker() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mEventQueue = new ArrayBlockingQueue(20);
    }

    public static void disable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            sEnabled = false;
        }
    }

    public static DraweeEventTracker newInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? sEnabled ? new DraweeEventTracker() : sInstance : (DraweeEventTracker) invokeV.objValue;
    }

    public void recordEvent(Event event) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, event) == null) && sEnabled) {
            if (this.mEventQueue.size() + 1 > 20) {
                this.mEventQueue.poll();
            }
            this.mEventQueue.add(event);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mEventQueue.toString() : (String) invokeV.objValue;
    }
}
