package com.qq.e.comm.plugin.ac;

import android.app.Dialog;
import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.qq.e.comm.plugin.util.ao;
import com.qq.e.comm.plugin.util.o;
/* loaded from: classes3.dex */
public class e extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    Context f11848a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f11849b;
    private com.qq.e.comm.plugin.ab.d.a c;
    private double d;
    private double e;
    private double f;
    private int g;
    private int h;
    private double i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;

    public e(Context context) {
        super(context);
        this.d = 0.8d;
        this.e = 1.0d;
        this.f = 0.095d;
        this.i = 0.8d;
        this.l = false;
        this.m = true;
        this.f11848a = context;
    }

    private void a() {
        this.f11849b = new LinearLayout(this.f11848a);
        this.f11849b.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f11849b.setOrientation(1);
        this.f11849b.setBackgroundColor(-1);
        setContentView(this.f11849b);
        this.c = new com.qq.e.comm.plugin.ab.d.e(this.f11848a, null).a();
        this.c.b().setLayerType(1, null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        ImageView imageView = new ImageView(this.f11848a);
        imageView.setImageBitmap(ao.a("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAAbFBMVEUAAAAAAAD////p6eknJyf/\n//8MDAz///////8REREbGxs9PT11dXWlpaX39/f///////////////9qamoZGRksLCxQUFBkZGSL\ni4u/v7/Z2dny8vL///////////////////////////////8d9apUAAAAI3RSTlOAAE3qikd6JQV3\nc2hbVE5AKx4RoYZtY15YUVBORD48MhoKNpZmpn4AAAHhSURBVFjDpZfbloIwDEXPVFsoFwW830H/\n/x+HRMYRIQIr54EHl2eTNiVN8CMoLIPb5WyNsefLLShD6X/9gCJbmg8ts2IsIAwad4cRhIMAslsj\nyhLiOyB/2Q/JduMd4PxmmxxeiPwroLoa1iKNHVpycbowrGslAwr7tCcOPXLJE2ELCZAb1t5DkN8b\nVt4PyAwpjfBFUWpIWR/gbkg7DGhnSPcugN9/ijGo+NSKAe/rP0YYoejI+9AGFOz3GCXPhOIdUFmK\nP8JIRbQKW70B+PzEGK2YT9Q/IBf2fyAX+R8gtJR/TFJKiwgbQEC4CJMUkScgQBPAHhO1b0LAM4CF\nx0T5BYXAAKo/CVpardHReoWWEqpRBCgoANf2P2ZzfGg+e7QJjkIoakDWTcF6RoRP/2zdTURWA5Y9\nZ2hOBPGHRjGvASHlw0EiyH44coYoqX4CEkH2A1RpSwScA5kg+zkPAW71cwuZIPuxra03XOrnBjJB\n9mNTWy84108PmSD74WvrGZaTIBNkP6fBgnIByATZD/aqAeolqDdRnUb1QVIfZfXHpP6ctQVFXdLU\nRVVb1tUXi/pq016u6utd22BoWxx1k6Vt87SNprbVVTfb+nZfP3DoRx790KUf+/SDp3701Q/f6vH/\nFzOPJ4ULw0zxAAAAAElFTkSuQmCC\n"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.h, this.h);
        layoutParams2.gravity = 83;
        imageView.setLayoutParams(layoutParams2);
        FrameLayout frameLayout = new FrameLayout(this.f11848a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(this.g, this.g);
        layoutParams3.gravity = 5;
        frameLayout.setLayoutParams(layoutParams3);
        frameLayout.setBackgroundColor(-1);
        frameLayout.addView(imageView);
        this.f11849b.addView(frameLayout);
        this.f11849b.addView(this.c.b(), layoutParams);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.ac.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.cancel();
            }
        });
    }

    private void b() {
        d();
        a();
        setCanceledOnTouchOutside(this.l);
        setCancelable(this.m);
    }

    private void b(String str) {
        this.c.a(str);
    }

    private void c() {
        show();
        Window window = getWindow();
        if (window != null) {
            window.setLayout(this.j, this.k);
        }
    }

    private void d() {
        Pair<Integer, Integer> a2 = o.a();
        this.j = (int) (Math.min(((Integer) a2.first).intValue(), ((Integer) a2.second).intValue()) * this.d);
        this.k = (int) (this.j * this.e);
        this.g = (int) (this.j * this.f);
        this.h = (int) (this.g * this.i);
    }

    public void a(String str) {
        b();
        b(str);
        c();
    }
}
