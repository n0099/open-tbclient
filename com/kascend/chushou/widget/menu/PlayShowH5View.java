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
/* loaded from: classes6.dex */
public class PlayShowH5View extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f4288a;
    private View b;
    private boolean c;
    private Animation e;
    private com.kascend.chushou.view.h5.a ptj;
    private a ptk;

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
        this.f4288a = (TextView) findViewById(a.f.tv_title);
        this.b = findViewById(a.f.view_playshow_space);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.c) {
            return false;
        }
        if (this.ptj == null || !this.ptj.a(i, keyEvent)) {
            a();
            return true;
        }
        return true;
    }

    public void a(FragmentManager fragmentManager, String str, H5Options h5Options, Animation animation, Animation animation2) {
        this.e = animation2;
        if (h.isEmpty(str)) {
            this.f4288a.setVisibility(8);
            this.b.setVisibility(8);
        } else {
            this.f4288a.setVisibility(0);
            this.b.setVisibility(0);
            this.f4288a.setText(str);
        }
        if (this.ptj != null) {
            if (this.ptj.isAdded()) {
                fragmentManager.beginTransaction().remove(this.ptj).commitAllowingStateLoss();
            }
            this.ptj = null;
        }
        this.ptj = com.kascend.chushou.view.h5.a.a(h5Options, new com.kascend.chushou.widget.cswebview.a().a(new d() { // from class: com.kascend.chushou.widget.menu.PlayShowH5View.1
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
        fragmentManager.beginTransaction().add(a.f.activity_h5_container, this.ptj).commitAllowingStateLoss();
        setVisibility(0);
        if (!this.c) {
            if (this.ptk != null) {
                this.ptk.a();
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
        this.ptj.a(new a.InterfaceC0997a() { // from class: com.kascend.chushou.widget.menu.PlayShowH5View.3
            @Override // com.kascend.chushou.view.h5.a.InterfaceC0997a
            public void a(String str2) {
                if (!h.isEmpty(str2) && PlayShowH5View.this.f4288a != null) {
                    PlayShowH5View.this.f4288a.setText(str2);
                }
            }
        });
    }

    public boolean a() {
        if (!this.c) {
            return false;
        }
        if (this.ptk != null) {
            this.ptk.b();
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
        this.ptk = aVar;
    }
}
