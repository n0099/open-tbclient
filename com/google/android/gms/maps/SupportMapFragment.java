package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.internal.bb;
import com.google.android.gms.internal.bd;
import com.google.android.gms.internal.be;
import com.google.android.gms.internal.cv;
import com.google.android.gms.internal.cw;
import com.google.android.gms.internal.x;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;
/* loaded from: classes.dex */
public class SupportMapFragment extends Fragment {
    private final b a = new b(this);
    private GoogleMap b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements LifecycleDelegate {
        private final Fragment a;
        private final IMapFragmentDelegate b;

        public a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.b = (IMapFragmentDelegate) x.a(iMapFragmentDelegate);
            this.a = (Fragment) x.a(fragment);
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) bd.a(this.b.a(bd.a(layoutInflater), bd.a(viewGroup), bundle));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void a() {
            try {
                this.b.b();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void a(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                this.b.a(bd.a(activity), (GoogleMapOptions) bundle.getParcelable("MapOptions"), bundle2);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void a(Bundle bundle) {
            if (bundle == null) {
                try {
                    bundle = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle g = this.a.g();
            if (g != null && g.containsKey("MapOptions")) {
                cv.a(bundle, "MapOptions", g.getParcelable("MapOptions"));
            }
            this.b.a(bundle);
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void b() {
            try {
                this.b.c();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void b(Bundle bundle) {
            try {
                this.b.b(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void c() {
            try {
                this.b.d();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void d() {
            try {
                this.b.e();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void e() {
            try {
                this.b.f();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public IMapFragmentDelegate f() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends bb {
        protected be a;
        private final Fragment b;
        private Activity c;

        b(Fragment fragment) {
            this.b = fragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Activity activity) {
            this.c = activity;
            g();
        }

        @Override // com.google.android.gms.internal.bb
        protected void a(be beVar) {
            this.a = beVar;
            g();
        }

        public void g() {
            if (this.c == null || this.a == null || a() != null) {
                return;
            }
            try {
                MapsInitializer.a(this.c);
                this.a.a(new a(this.b, cw.a(this.c).b(bd.a(this.c))));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            } catch (GooglePlayServicesNotAvailableException e2) {
            }
        }
    }

    public final GoogleMap A() {
        IMapFragmentDelegate a2 = a();
        if (a2 == null) {
            return null;
        }
        try {
            IGoogleMapDelegate a3 = a2.a();
            if (a3 != null) {
                if (this.b == null || this.b.a().asBinder() != a3.asBinder()) {
                    this.b = new GoogleMap(a3);
                }
                return this.b;
            }
            return null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.a.a(layoutInflater, viewGroup, bundle);
    }

    protected IMapFragmentDelegate a() {
        this.a.g();
        if (this.a.a() == null) {
            return null;
        }
        return ((a) this.a.a()).f();
    }

    @Override // android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        this.a.a(activity);
    }

    @Override // android.support.v4.app.Fragment
    public void a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.a(activity, attributeSet, bundle);
        this.a.a(activity);
        GoogleMapOptions a2 = GoogleMapOptions.a(activity, attributeSet);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("MapOptions", a2);
        this.a.a(activity, bundle2, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.a.a(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void e() {
        this.a.d();
        super.e();
    }

    @Override // android.support.v4.app.Fragment
    public void e(Bundle bundle) {
        this.a.b(bundle);
        super.e(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void m() {
        super.m();
        this.a.b();
    }

    @Override // android.support.v4.app.Fragment
    public void n() {
        this.a.c();
        super.n();
    }

    @Override // android.support.v4.app.Fragment
    public void o() {
        this.a.e();
        super.o();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.a.f();
        super.onLowMemory();
    }
}
