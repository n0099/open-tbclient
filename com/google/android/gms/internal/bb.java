package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class bb {
    private LifecycleDelegate a;
    private Bundle b;
    private LinkedList c;
    private final be d = new be() { // from class: com.google.android.gms.internal.bb.1
        @Override // com.google.android.gms.internal.be
        public void a(LifecycleDelegate lifecycleDelegate) {
            bb.this.a = lifecycleDelegate;
            Iterator it = bb.this.c.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(bb.this.a);
            }
            bb.this.c.clear();
            bb.this.b = null;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        int a();

        void a(LifecycleDelegate lifecycleDelegate);
    }

    private void a(int i) {
        while (!this.c.isEmpty() && ((a) this.c.getLast()).a() >= i) {
            this.c.removeLast();
        }
    }

    private void a(Bundle bundle, a aVar) {
        if (this.a != null) {
            aVar.a(this.a);
            return;
        }
        if (this.c == null) {
            this.c = new LinkedList();
        }
        this.c.add(aVar);
        if (bundle != null) {
            if (this.b == null) {
                this.b = (Bundle) bundle.clone();
            } else {
                this.b.putAll(bundle);
            }
        }
        a(this.d);
    }

    public View a(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        final FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        a(bundle, new a() { // from class: com.google.android.gms.internal.bb.4
            @Override // com.google.android.gms.internal.bb.a
            public int a() {
                return 2;
            }

            @Override // com.google.android.gms.internal.bb.a
            public void a(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(bb.this.a.a(layoutInflater, viewGroup, bundle));
            }
        });
        if (this.a == null) {
            a(frameLayout);
        }
        return frameLayout;
    }

    public LifecycleDelegate a() {
        return this.a;
    }

    public void a(final Activity activity, final Bundle bundle, final Bundle bundle2) {
        a(bundle2, new a() { // from class: com.google.android.gms.internal.bb.2
            @Override // com.google.android.gms.internal.bb.a
            public int a() {
                return 0;
            }

            @Override // com.google.android.gms.internal.bb.a
            public void a(LifecycleDelegate lifecycleDelegate) {
                bb.this.a.a(activity, bundle, bundle2);
            }
        });
    }

    public void a(final Bundle bundle) {
        a(bundle, new a() { // from class: com.google.android.gms.internal.bb.3
            @Override // com.google.android.gms.internal.bb.a
            public int a() {
                return 1;
            }

            @Override // com.google.android.gms.internal.bb.a
            public void a(LifecycleDelegate lifecycleDelegate) {
                bb.this.a.a(bundle);
            }
        });
    }

    public void a(FrameLayout frameLayout) {
        final Context context = frameLayout.getContext();
        final int a2 = GooglePlayServicesUtil.a(context);
        String b = GooglePlayServicesUtil.b(context, a2, -1);
        String a3 = GooglePlayServicesUtil.a(context, a2);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(b);
        linearLayout.addView(textView);
        if (a3 != null) {
            Button button = new Button(context);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(a3);
            linearLayout.addView(button);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.gms.internal.bb.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    context.startActivity(GooglePlayServicesUtil.a(context, a2, -1));
                }
            });
        }
    }

    protected abstract void a(be beVar);

    public void b() {
        a((Bundle) null, new a() { // from class: com.google.android.gms.internal.bb.6
            @Override // com.google.android.gms.internal.bb.a
            public int a() {
                return 3;
            }

            @Override // com.google.android.gms.internal.bb.a
            public void a(LifecycleDelegate lifecycleDelegate) {
                bb.this.a.a();
            }
        });
    }

    public void b(Bundle bundle) {
        if (this.a != null) {
            this.a.b(bundle);
        } else if (this.b != null) {
            bundle.putAll(this.b);
        }
    }

    public void c() {
        if (this.a != null) {
            this.a.b();
        } else {
            a(3);
        }
    }

    public void d() {
        if (this.a != null) {
            this.a.c();
        } else {
            a(2);
        }
    }

    public void e() {
        if (this.a != null) {
            this.a.d();
        } else {
            a(1);
        }
    }

    public void f() {
        if (this.a != null) {
            this.a.e();
        }
    }
}
