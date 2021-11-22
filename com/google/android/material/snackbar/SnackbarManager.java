package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class SnackbarManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LONG_DURATION_MS = 2750;
    public static final int MSG_TIMEOUT = 0;
    public static final int SHORT_DURATION_MS = 1500;
    public static SnackbarManager snackbarManager;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public SnackbarRecord currentSnackbar;
    @NonNull
    public final Handler handler;
    @NonNull
    public final Object lock;
    @Nullable
    public SnackbarRecord nextSnackbar;

    /* loaded from: classes11.dex */
    public interface Callback {
        void dismiss(int i2);

        void show();
    }

    /* loaded from: classes11.dex */
    public static class SnackbarRecord {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final WeakReference<Callback> callback;
        public int duration;
        public boolean paused;

        public SnackbarRecord(int i2, Callback callback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), callback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.callback = new WeakReference<>(callback);
            this.duration = i2;
        }

        public boolean isSnackbar(@Nullable Callback callback) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, callback)) == null) ? callback != null && this.callback.get() == callback : invokeL.booleanValue;
        }
    }

    public SnackbarManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.lock = new Object();
        this.handler = new Handler(Looper.getMainLooper(), new Handler.Callback(this) { // from class: com.google.android.material.snackbar.SnackbarManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SnackbarManager this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(@NonNull Message message) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, message)) == null) {
                    if (message.what != 0) {
                        return false;
                    }
                    this.this$0.handleTimeout((SnackbarRecord) message.obj);
                    return true;
                }
                return invokeL.booleanValue;
            }
        });
    }

    private boolean cancelSnackbarLocked(@NonNull SnackbarRecord snackbarRecord, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, this, snackbarRecord, i2)) == null) {
            Callback callback = snackbarRecord.callback.get();
            if (callback != null) {
                this.handler.removeCallbacksAndMessages(snackbarRecord);
                callback.dismiss(i2);
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static SnackbarManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (snackbarManager == null) {
                snackbarManager = new SnackbarManager();
            }
            return snackbarManager;
        }
        return (SnackbarManager) invokeV.objValue;
    }

    private boolean isCurrentSnackbarLocked(Callback callback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, callback)) == null) {
            SnackbarRecord snackbarRecord = this.currentSnackbar;
            return snackbarRecord != null && snackbarRecord.isSnackbar(callback);
        }
        return invokeL.booleanValue;
    }

    private boolean isNextSnackbarLocked(Callback callback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, callback)) == null) {
            SnackbarRecord snackbarRecord = this.nextSnackbar;
            return snackbarRecord != null && snackbarRecord.isSnackbar(callback);
        }
        return invokeL.booleanValue;
    }

    private void scheduleTimeoutLocked(@NonNull SnackbarRecord snackbarRecord) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, snackbarRecord) == null) || (i2 = snackbarRecord.duration) == -2) {
            return;
        }
        if (i2 <= 0) {
            i2 = i2 == -1 ? 1500 : LONG_DURATION_MS;
        }
        this.handler.removeCallbacksAndMessages(snackbarRecord);
        Handler handler = this.handler;
        handler.sendMessageDelayed(Message.obtain(handler, 0, snackbarRecord), i2);
    }

    private void showNextSnackbarLocked() {
        SnackbarRecord snackbarRecord;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || (snackbarRecord = this.nextSnackbar) == null) {
            return;
        }
        this.currentSnackbar = snackbarRecord;
        this.nextSnackbar = null;
        Callback callback = snackbarRecord.callback.get();
        if (callback != null) {
            callback.show();
        } else {
            this.currentSnackbar = null;
        }
    }

    public void dismiss(Callback callback, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, callback, i2) == null) {
            synchronized (this.lock) {
                if (isCurrentSnackbarLocked(callback)) {
                    cancelSnackbarLocked(this.currentSnackbar, i2);
                } else if (isNextSnackbarLocked(callback)) {
                    cancelSnackbarLocked(this.nextSnackbar, i2);
                }
            }
        }
    }

    public void handleTimeout(@NonNull SnackbarRecord snackbarRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, snackbarRecord) == null) {
            synchronized (this.lock) {
                if (this.currentSnackbar == snackbarRecord || this.nextSnackbar == snackbarRecord) {
                    cancelSnackbarLocked(snackbarRecord, 2);
                }
            }
        }
    }

    public boolean isCurrent(Callback callback) {
        InterceptResult invokeL;
        boolean isCurrentSnackbarLocked;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, callback)) == null) {
            synchronized (this.lock) {
                isCurrentSnackbarLocked = isCurrentSnackbarLocked(callback);
            }
            return isCurrentSnackbarLocked;
        }
        return invokeL.booleanValue;
    }

    public boolean isCurrentOrNext(Callback callback) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, callback)) == null) {
            synchronized (this.lock) {
                z = isCurrentSnackbarLocked(callback) || isNextSnackbarLocked(callback);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void onDismissed(Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, callback) == null) {
            synchronized (this.lock) {
                if (isCurrentSnackbarLocked(callback)) {
                    this.currentSnackbar = null;
                    if (this.nextSnackbar != null) {
                        showNextSnackbarLocked();
                    }
                }
            }
        }
    }

    public void onShown(Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, callback) == null) {
            synchronized (this.lock) {
                if (isCurrentSnackbarLocked(callback)) {
                    scheduleTimeoutLocked(this.currentSnackbar);
                }
            }
        }
    }

    public void pauseTimeout(Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, callback) == null) {
            synchronized (this.lock) {
                if (isCurrentSnackbarLocked(callback) && !this.currentSnackbar.paused) {
                    this.currentSnackbar.paused = true;
                    this.handler.removeCallbacksAndMessages(this.currentSnackbar);
                }
            }
        }
    }

    public void restoreTimeoutIfPaused(Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, callback) == null) {
            synchronized (this.lock) {
                if (isCurrentSnackbarLocked(callback) && this.currentSnackbar.paused) {
                    this.currentSnackbar.paused = false;
                    scheduleTimeoutLocked(this.currentSnackbar);
                }
            }
        }
    }

    public void show(int i2, Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, callback) == null) {
            synchronized (this.lock) {
                if (isCurrentSnackbarLocked(callback)) {
                    this.currentSnackbar.duration = i2;
                    this.handler.removeCallbacksAndMessages(this.currentSnackbar);
                    scheduleTimeoutLocked(this.currentSnackbar);
                    return;
                }
                if (isNextSnackbarLocked(callback)) {
                    this.nextSnackbar.duration = i2;
                } else {
                    this.nextSnackbar = new SnackbarRecord(i2, callback);
                }
                if (this.currentSnackbar == null || !cancelSnackbarLocked(this.currentSnackbar, 4)) {
                    this.currentSnackbar = null;
                    showNextSnackbarLocked();
                }
            }
        }
    }
}
