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
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.chushou.view.h5.H5Options;
import com.kascend.chushou.view.h5.a;
import com.kascend.chushou.widget.cswebview.d;
import tv.chushou.zues.utils.h;
/* loaded from: classes5.dex */
public class PlayShowH5View extends FrameLayout {
    private TextView a;
    private View b;
    private boolean c;
    private Animation e;
    private com.kascend.chushou.view.h5.a ncK;
    private a ncL;

    public PlayShowH5View(@NonNull Context context) {
        this(context, null);
    }

    public PlayShowH5View(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayShowH5View(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = false;
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(a.h.view_playshow_h5, (ViewGroup) this, true);
        this.a = (TextView) findViewById(a.f.tv_title);
        this.b = findViewById(a.f.view_playshow_space);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.c) {
            return false;
        }
        if (this.ncK == null || !this.ncK.a(i, keyEvent)) {
            a();
            return true;
        }
        return true;
    }

    public void a(FragmentManager fragmentManager, String str, H5Options h5Options, Animation animation, Animation animation2) {
        this.e = animation2;
        if (h.isEmpty(str)) {
            this.a.setVisibility(8);
            this.b.setVisibility(8);
        } else {
            this.a.setVisibility(0);
            this.b.setVisibility(0);
            this.a.setText(str);
        }
        if (this.ncK != null) {
            if (this.ncK.isAdded()) {
                fragmentManager.beginTransaction().remove(this.ncK).commitAllowingStateLoss();
            }
            this.ncK = null;
        }
        this.ncK = com.kascend.chushou.view.h5.a.a(h5Options, new com.kascend.chushou.widget.cswebview.a().a(new d() { // from class: com.kascend.chushou.widget.menu.PlayShowH5View.1
            @Override // com.kascend.chushou.widget.cswebview.d
            public void a(Object obj) {
                if (ViewCompat.isAttachedToWindow(PlayShowH5View.this)) {
                    PlayShowH5View.this.a();
                }
            }

            @Override // com.kascend.chushou.widget.cswebview.d
            public void a(String str2) {
            }
        }));
        fragmentManager.beginTransaction().add(a.f.activity_h5_container, this.ncK).commitAllowingStateLoss();
        setVisibility(0);
        if (!this.c) {
            if (this.ncL != null) {
                this.ncL.a();
            }
            animation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.widget.menu.PlayShowH5View.2
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation3) {
                    super.onAnimationEnd(animation3);
                    PlayShowH5View.this.c = true;
                }
            });
            startAnimation(animation);
        }
        this.ncK.a(new a.InterfaceC0822a() { // from class: com.kascend.chushou.widget.menu.PlayShowH5View.3
            @Override // com.kascend.chushou.view.h5.a.InterfaceC0822a
            public void a(String str2) {
                if (!h.isEmpty(str2) && PlayShowH5View.this.a != null) {
                    PlayShowH5View.this.a.setText(str2);
                }
            }
        });
    }

    public boolean a() {
        if (!this.c) {
            return false;
        }
        if (this.ncL != null) {
            this.ncL.b();
        }
        this.e.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.widget.menu.PlayShowH5View.4
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                PlayShowH5View.this.c = false;
                PlayShowH5View.this.setVisibility(8);
            }
        });
        startAnimation(this.e);
        return true;
    }

    public boolean b() {
        return this.c;
    }

    public void setVisibilityListener(a aVar) {
        this.ncL = aVar;
    }
}
