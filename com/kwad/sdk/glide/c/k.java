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
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class k implements Handler.Callback {
    public static final a i = new a() { // from class: com.kwad.sdk.glide.c.k.1
        @Override // com.kwad.sdk.glide.c.k.a
        @NonNull
        public com.kwad.sdk.glide.g a(@NonNull com.kwad.sdk.glide.c cVar, @NonNull h hVar, @NonNull l lVar, @NonNull Context context) {
            return new com.kwad.sdk.glide.g(cVar, hVar, lVar, context);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public volatile com.kwad.sdk.glide.g f35491c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f35492d;

    /* renamed from: e  reason: collision with root package name */
    public final a f35493e;
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    public final Map<FragmentManager, Object> f35489a = new HashMap();
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    public final Map<KsFragmentManager, n> f35490b = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public final ArrayMap<View, KsFragment> f35494f = new ArrayMap<>();

    /* renamed from: g  reason: collision with root package name */
    public final ArrayMap<View, Fragment> f35495g = new ArrayMap<>();

    /* renamed from: h  reason: collision with root package name */
    public final Bundle f35496h = new Bundle();

    /* loaded from: classes6.dex */
    public interface a {
        @NonNull
        com.kwad.sdk.glide.g a(@NonNull com.kwad.sdk.glide.c cVar, @NonNull h hVar, @NonNull l lVar, @NonNull Context context);
    }

    public k(@Nullable a aVar) {
        this.f35493e = aVar == null ? i : aVar;
        this.f35492d = new Handler(Looper.getMainLooper(), this);
    }

    @NonNull
    private n a(@NonNull KsFragmentManager ksFragmentManager, @Nullable KsFragment ksFragment, boolean z) {
        n nVar = (n) ksFragmentManager.findFragmentByTag("com.kwad.sdk.glide.manager");
        if (nVar == null && (nVar = this.f35490b.get(ksFragmentManager)) == null) {
            nVar = new n();
            nVar.a(ksFragment);
            if (z) {
                nVar.a().a();
            }
            this.f35490b.put(ksFragmentManager, nVar);
            ksFragmentManager.beginTransaction().add(nVar, "com.kwad.sdk.glide.manager").commitAllowingStateLoss();
            this.f35492d.obtainMessage(2, ksFragmentManager).sendToTarget();
        }
        return nVar;
    }

    @NonNull
    private com.kwad.sdk.glide.g a(@NonNull Context context, @NonNull KsFragmentManager ksFragmentManager, @Nullable KsFragment ksFragment, boolean z) {
        n a2 = a(ksFragmentManager, ksFragment, z);
        com.kwad.sdk.glide.g b2 = a2.b();
        if (b2 == null) {
            com.kwad.sdk.glide.g a3 = this.f35493e.a(com.kwad.sdk.glide.c.a(context), a2.a(), a2.c(), context);
            a2.a(a3);
            return a3;
        }
        return b2;
    }

    public static boolean a(Activity activity) {
        return !activity.isFinishing();
    }

    @NonNull
    private com.kwad.sdk.glide.g b(@NonNull Context context) {
        if (this.f35491c == null) {
            synchronized (this) {
                if (this.f35491c == null) {
                    this.f35491c = this.f35493e.a(com.kwad.sdk.glide.c.a(context.getApplicationContext()), new b(), new g(), context.getApplicationContext());
                }
            }
        }
        return this.f35491c;
    }

    @NonNull
    public n a(KsFragmentManager ksFragmentManager, Activity activity) {
        return a(ksFragmentManager, null, a(activity));
    }

    @NonNull
    public com.kwad.sdk.glide.g a(@NonNull Context context) {
        if (context != null) {
            return b(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
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
        Map map;
        Object obj2;
        int i2 = message.what;
        Object obj3 = null;
        boolean z = true;
        if (i2 == 1) {
            obj = (FragmentManager) message.obj;
            map = this.f35489a;
        } else if (i2 != 2) {
            z = false;
            obj2 = null;
            if (z && obj3 == null && Log.isLoggable(RequestManagerRetriever.TAG, 5)) {
                Log.w(RequestManagerRetriever.TAG, "Failed to remove expected request manager fragment, manager: " + obj2);
            }
            return z;
        } else {
            obj = (KsFragmentManager) message.obj;
            map = this.f35490b;
        }
        Object obj4 = obj;
        obj3 = map.remove(obj);
        obj2 = obj4;
        if (z) {
            Log.w(RequestManagerRetriever.TAG, "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z;
    }
}
