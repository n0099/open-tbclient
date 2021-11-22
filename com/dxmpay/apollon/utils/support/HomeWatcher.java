package com.dxmpay.apollon.utils.support;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class HomeWatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f63167a;

    /* renamed from: b  reason: collision with root package name */
    public final IntentFilter f63168b;

    /* renamed from: c  reason: collision with root package name */
    public OnHomePressedListener f63169c;

    /* renamed from: d  reason: collision with root package name */
    public a f63170d;

    /* loaded from: classes11.dex */
    public interface OnHomePressedListener {
        void onHomeLongPressed();

        void onHomePressed();
    }

    /* loaded from: classes11.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f63171a;

        /* renamed from: b  reason: collision with root package name */
        public final String f63172b;

        /* renamed from: c  reason: collision with root package name */
        public final String f63173c;

        /* renamed from: d  reason: collision with root package name */
        public final String f63174d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomeWatcher f63175e;

        public a(HomeWatcher homeWatcher) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homeWatcher};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63175e = homeWatcher;
            this.f63171a = "reason";
            this.f63172b = "globalactions";
            this.f63173c = PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_RECENT_APPS;
            this.f63174d = "homekey";
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || !intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") || (stringExtra = intent.getStringExtra("reason")) == null || this.f63175e.f63169c == null) {
                return;
            }
            if (stringExtra.equals("homekey")) {
                this.f63175e.f63169c.onHomePressed();
            } else if (stringExtra.equals(PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_RECENT_APPS)) {
                this.f63175e.f63169c.onHomeLongPressed();
            }
        }
    }

    public HomeWatcher(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63167a = context;
        this.f63168b = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    }

    public void setOnHomePressedListener(OnHomePressedListener onHomePressedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onHomePressedListener) == null) {
            this.f63169c = onHomePressedListener;
            this.f63170d = new a(this);
        }
    }

    public void startWatch() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f63170d) == null) {
            return;
        }
        this.f63167a.registerReceiver(aVar, this.f63168b);
    }

    public void stopWatch() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f63170d) == null) {
            return;
        }
        this.f63167a.unregisterReceiver(aVar);
    }
}
