package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.components.DeferredReleaser;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class DeferredReleaserConcurrentImpl extends DeferredReleaser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object mLock;
    public ArrayList mPendingReleasables;
    public ArrayList mTempList;
    public final Handler mUiHandler;
    public final Runnable releaseRunnable;

    public DeferredReleaserConcurrentImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLock = new Object();
        this.releaseRunnable = new Runnable(this) { // from class: com.facebook.drawee.components.DeferredReleaserConcurrentImpl.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DeferredReleaserConcurrentImpl this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    synchronized (this.this$0.mLock) {
                        ArrayList arrayList = this.this$0.mTempList;
                        this.this$0.mTempList = this.this$0.mPendingReleasables;
                        this.this$0.mPendingReleasables = arrayList;
                    }
                    int size = this.this$0.mTempList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ((DeferredReleaser.Releasable) this.this$0.mTempList.get(i3)).release();
                    }
                    this.this$0.mTempList.clear();
                }
            }
        };
        this.mPendingReleasables = new ArrayList();
        this.mTempList = new ArrayList();
        this.mUiHandler = new Handler(Looper.getMainLooper());
    }

    @Override // com.facebook.drawee.components.DeferredReleaser
    public void cancelDeferredRelease(DeferredReleaser.Releasable releasable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, releasable) == null) {
            synchronized (this.mLock) {
                this.mPendingReleasables.remove(releasable);
            }
        }
    }

    @Override // com.facebook.drawee.components.DeferredReleaser
    public void scheduleDeferredRelease(DeferredReleaser.Releasable releasable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, releasable) == null) {
            if (!DeferredReleaser.isOnUiThread()) {
                releasable.release();
                return;
            }
            synchronized (this.mLock) {
                if (this.mPendingReleasables.contains(releasable)) {
                    return;
                }
                this.mPendingReleasables.add(releasable);
                boolean z = true;
                if (this.mPendingReleasables.size() != 1) {
                    z = false;
                }
                if (z) {
                    this.mUiHandler.post(this.releaseRunnable);
                }
            }
        }
    }
}
