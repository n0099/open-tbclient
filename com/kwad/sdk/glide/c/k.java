package com.kwad.sdk.glide.c;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class k implements Handler.Callback {
    private static final a i = new a() { // from class: com.kwad.sdk.glide.c.k.1
        @Override // com.kwad.sdk.glide.c.k.a
        @NonNull
        public com.kwad.sdk.glide.g a(@NonNull com.kwad.sdk.glide.c cVar, @NonNull h hVar, @NonNull l lVar, @NonNull Context context) {
            return new com.kwad.sdk.glide.g(cVar, hVar, lVar, context);
        }
    };
    private volatile com.kwad.sdk.glide.g c;
    private final Handler d;
    private final a e;
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    final Map<FragmentManager, Object> f10251a = new HashMap();
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    final Map<KsFragmentManager, n> f10252b = new HashMap();
    private final ArrayMap<View, KsFragment> f = new ArrayMap<>();
    private final ArrayMap<View, Fragment> g = new ArrayMap<>();
    private final Bundle h = new Bundle();

    /* loaded from: classes5.dex */
    public interface a {
        @NonNull
        com.kwad.sdk.glide.g a(@NonNull com.kwad.sdk.glide.c cVar, @NonNull h hVar, @NonNull l lVar, @NonNull Context context);
    }

    public k(@Nullable a aVar) {
        this.e = aVar == null ? i : aVar;
        this.d = new Handler(Looper.getMainLooper(), this);
    }

    @NonNull
    private n a(@NonNull KsFragmentManager ksFragmentManager, @Nullable KsFragment ksFragment, boolean z) {
        n nVar = (n) ksFragmentManager.findFragmentByTag("com.kwad.sdk.glide.manager");
        if (nVar == null && (nVar = this.f10252b.get(ksFragmentManager)) == null) {
            nVar = new n();
            nVar.a(ksFragment);
            if (z) {
                nVar.a().a();
            }
            this.f10252b.put(ksFragmentManager, nVar);
            ksFragmentManager.beginTransaction().add(nVar, "com.kwad.sdk.glide.manager").commitAllowingStateLoss();
            this.d.obtainMessage(2, ksFragmentManager).sendToTarget();
        }
        return nVar;
    }

    @NonNull
    private com.kwad.sdk.glide.g a(@NonNull Context context, @NonNull KsFragmentManager ksFragmentManager, @Nullable KsFragment ksFragment, boolean z) {
        n a2 = a(ksFragmentManager, ksFragment, z);
        com.kwad.sdk.glide.g b2 = a2.b();
        if (b2 == null) {
            com.kwad.sdk.glide.g a3 = this.e.a(com.kwad.sdk.glide.c.a(context), a2.a(), a2.c(), context);
            a2.a(a3);
            return a3;
        }
        return b2;
    }

    private static boolean a(Activity activity) {
        return !activity.isFinishing();
    }

    @NonNull
    private com.kwad.sdk.glide.g b(@NonNull Context context) {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = this.e.a(com.kwad.sdk.glide.c.a(context.getApplicationContext()), new b(), new g(), context.getApplicationContext());
                }
            }
        }
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public n a(KsFragmentManager ksFragmentManager, Activity activity) {
        return a(ksFragmentManager, null, a(activity));
    }

    @NonNull
    public com.kwad.sdk.glide.g a(@NonNull Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        return b(context);
    }

    @NonNull
    public com.kwad.sdk.glide.g a(@NonNull KsFragment ksFragment) {
        com.kwad.sdk.glide.g.j.a(ksFragment.getActivity(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (com.kwad.sdk.glide.g.k.c()) {
            return b(ksFragment.getActivity().getApplicationContext());
        }
        return a(ksFragment.getActivity(), ksFragment.getChildFragmentManager(), ksFragment, ksFragment.isVisible());
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        n remove;
        boolean z = true;
        switch (message.what) {
            case 1:
                obj = (FragmentManager) message.obj;
                remove = this.f10251a.remove(obj);
                break;
            case 2:
                obj = (KsFragmentManager) message.obj;
                remove = this.f10252b.remove(obj);
                break;
            default:
                z = false;
                obj = null;
                remove = null;
                break;
        }
        if (z && remove == null && Log.isLoggable("RMRetriever", 5)) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
        }
        return z;
    }
}
