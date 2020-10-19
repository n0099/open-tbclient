package com.kascend.chushou.widget.menu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kascend.chushou.a;
import com.kascend.chushou.view.h5.H5Options;
import com.kascend.chushou.widget.cswebview.d;
/* loaded from: classes6.dex */
public class PopH5Menu extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f4291a;
    private boolean b;
    private Animation d;
    private boolean f;
    private com.kascend.chushou.view.h5.a oBR;
    private a oBS;

    public PopH5Menu(@NonNull Context context) {
        this(context, null, 0);
    }

    public PopH5Menu(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PopH5Menu(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = false;
        this.f = false;
        this.f4291a = context;
        LayoutInflater.from(this.f4291a).inflate(a.h.view_activity_h5, (ViewGroup) this, true);
        ((ImageView) findViewById(a.f.iv_activity_h5_close)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.iv_activity_h5_close) {
            a();
        }
    }

    public void a(FragmentManager fragmentManager, H5Options h5Options, Animation animation, Animation animation2) {
        this.d = animation2;
        if (this.oBR != null) {
            if (this.oBR.isAdded()) {
                fragmentManager.beginTransaction().remove(this.oBR).commitAllowingStateLoss();
            }
            this.oBR = null;
        }
        this.oBR = com.kascend.chushou.view.h5.a.a(h5Options, new com.kascend.chushou.widget.cswebview.a().a(new d() { // from class: com.kascend.chushou.widget.menu.PopH5Menu.1
            @Override // com.kascend.chushou.widget.cswebview.d
            public void a(Object obj) {
                if (ViewCompat.isAttachedToWindow(PopH5Menu.this)) {
                    PopH5Menu.this.a();
                }
            }

            @Override // com.kascend.chushou.widget.cswebview.d
            public void a(String str) {
            }
        }));
        fragmentManager.beginTransaction().add(a.f.activity_h5_container, this.oBR).commitAllowingStateLoss();
        setVisibility(0);
        if (!this.b) {
            if (this.oBS != null) {
                this.oBS.a();
            }
            animation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.widget.menu.PopH5Menu.2
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation3) {
                    super.onAnimationEnd(animation3);
                    PopH5Menu.this.b = true;
                }
            });
            startAnimation(animation);
        }
    }

    public boolean a() {
        if (this.b && !this.f) {
            this.f = true;
            if (this.oBS != null) {
                this.oBS.b();
            }
            this.d.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.widget.menu.PopH5Menu.3
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    PopH5Menu.this.f = false;
                    PopH5Menu.this.b = false;
                    PopH5Menu.this.setVisibility(8);
                }
            });
            startAnimation(this.d);
            return true;
        }
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.b) {
            return false;
        }
        if (this.oBR == null || !this.oBR.a(i, keyEvent)) {
            a();
            return true;
        }
        return true;
    }

    public boolean b() {
        return this.b;
    }

    public void setVisibilityListener(a aVar) {
        this.oBS = aVar;
    }
}
