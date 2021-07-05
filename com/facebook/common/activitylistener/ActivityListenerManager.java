package com.facebook.common.activitylistener;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class ActivityListenerManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class Listener extends BaseActivityListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<ActivityListener> mActivityListenerRef;

        public Listener(ActivityListener activityListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activityListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mActivityListenerRef = new WeakReference<>(activityListener);
        }

        @Nullable
        private ActivityListener getListenerOrCleanUp(Activity activity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, activity)) == null) {
                ActivityListener activityListener = this.mActivityListenerRef.get();
                if (activityListener == null) {
                    Preconditions.checkArgument(activity instanceof ListenableActivity);
                    ((ListenableActivity) activity).removeActivityListener(this);
                }
                return activityListener;
            }
            return (ActivityListener) invokeL.objValue;
        }

        @Override // com.facebook.common.activitylistener.BaseActivityListener, com.facebook.common.activitylistener.ActivityListener
        public void onActivityCreate(Activity activity) {
            ActivityListener listenerOrCleanUp;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, activity) == null) || (listenerOrCleanUp = getListenerOrCleanUp(activity)) == null) {
                return;
            }
            listenerOrCleanUp.onActivityCreate(activity);
        }

        @Override // com.facebook.common.activitylistener.BaseActivityListener, com.facebook.common.activitylistener.ActivityListener
        public void onDestroy(Activity activity) {
            ActivityListener listenerOrCleanUp;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) || (listenerOrCleanUp = getListenerOrCleanUp(activity)) == null) {
                return;
            }
            listenerOrCleanUp.onDestroy(activity);
        }

        @Override // com.facebook.common.activitylistener.BaseActivityListener, com.facebook.common.activitylistener.ActivityListener
        public void onPause(Activity activity) {
            ActivityListener listenerOrCleanUp;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) || (listenerOrCleanUp = getListenerOrCleanUp(activity)) == null) {
                return;
            }
            listenerOrCleanUp.onPause(activity);
        }

        @Override // com.facebook.common.activitylistener.BaseActivityListener, com.facebook.common.activitylistener.ActivityListener
        public void onResume(Activity activity) {
            ActivityListener listenerOrCleanUp;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, activity) == null) || (listenerOrCleanUp = getListenerOrCleanUp(activity)) == null) {
                return;
            }
            listenerOrCleanUp.onResume(activity);
        }

        @Override // com.facebook.common.activitylistener.BaseActivityListener, com.facebook.common.activitylistener.ActivityListener
        public void onStart(Activity activity) {
            ActivityListener listenerOrCleanUp;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, activity) == null) || (listenerOrCleanUp = getListenerOrCleanUp(activity)) == null) {
                return;
            }
            listenerOrCleanUp.onStart(activity);
        }

        @Override // com.facebook.common.activitylistener.BaseActivityListener, com.facebook.common.activitylistener.ActivityListener
        public void onStop(Activity activity) {
            ActivityListener listenerOrCleanUp;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, activity) == null) || (listenerOrCleanUp = getListenerOrCleanUp(activity)) == null) {
                return;
            }
            listenerOrCleanUp.onStop(activity);
        }
    }

    public ActivityListenerManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Nullable
    public static ListenableActivity getListenableActivity(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (!(context instanceof ListenableActivity) && (context instanceof ContextWrapper)) {
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (context instanceof ListenableActivity) {
                return (ListenableActivity) context;
            }
            return null;
        }
        return (ListenableActivity) invokeL.objValue;
    }

    public static void register(ActivityListener activityListener, Context context) {
        ListenableActivity listenableActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, activityListener, context) == null) || (listenableActivity = getListenableActivity(context)) == null) {
            return;
        }
        listenableActivity.addActivityListener(new Listener(activityListener));
    }
}
