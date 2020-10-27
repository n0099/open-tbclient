package com.kascend.chushou.player.ui.h5.redpacket;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.ConfigDetail;
import com.kascend.chushou.constants.H5Positon;
import com.kascend.chushou.constants.JSInterface;
import com.kascend.chushou.view.h5.H5Options;
import com.kascend.chushou.widget.cswebview.d;
import tv.chushou.basis.rxjava.annotation.Subscribe;
/* loaded from: classes6.dex */
public class c extends com.kascend.chushou.view.base.a {

    /* renamed from: a  reason: collision with root package name */
    private View f4181a;
    private View d;
    private H5Positon pkQ;
    private com.kascend.chushou.view.h5.b plY;
    private ConfigDetail plZ;

    public static c c(@NonNull ConfigDetail configDetail) {
        c cVar = new c();
        cVar.a(configDetail);
        return cVar;
    }

    @Override // com.kascend.chushou.view.base.a, android.support.v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setCanceledOnTouchOutside(false);
        return onCreateDialog;
    }

    @Override // com.kascend.chushou.view.base.a
    public View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.dialog_videoplayer_send_redpacket, viewGroup, false);
        this.f4181a = inflate;
        this.d = inflate.findViewById(a.f.view_close);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.ui.h5.redpacket.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismissAllowingStateLoss();
            }
        });
        tv.chushou.zues.a.a.register(this);
        return inflate;
    }

    @Override // com.kascend.chushou.view.base.a
    public void a(View view) {
        if (this.plZ == null || this.plZ.mPortrait == null) {
            dismissAllowingStateLoss();
            return;
        }
        this.pkQ = this.plZ.mPortrait;
        if (this.pkQ == null) {
            this.pkQ = new H5Positon();
            this.pkQ.mWidth = 84;
            this.pkQ.mHeight = 80;
        }
        H5Options h5Options = new H5Options();
        h5Options.e = true;
        h5Options.h = 0;
        h5Options.c = false;
        h5Options.b = true;
        h5Options.f4231a = this.plZ.mUrl;
        h5Options.d = true;
        h5Options.f = false;
        Point hD = tv.chushou.zues.utils.a.hD(this.b);
        int statusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.b);
        int i = hD.x;
        int i2 = hD.y - statusBarHeight;
        View findViewById = this.f4181a.findViewById(a.f.view_top);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        int i3 = (int) (((((100 - this.pkQ.mHeight) * 1.0d) / 2.0d) / 100.0d) * i2);
        layoutParams.height = i3;
        findViewById.setLayoutParams(layoutParams);
        View findViewById2 = this.f4181a.findViewById(a.f.dialog_send_redpacket_container);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        layoutParams2.height = (int) (((this.pkQ.mHeight * 1.0d) / 100.0d) * i2);
        findViewById2.setLayoutParams(layoutParams2);
        View findViewById3 = this.f4181a.findViewById(a.f.fl_bottom);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) findViewById3.getLayoutParams();
        layoutParams3.height = i3;
        findViewById3.setLayoutParams(layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams4.topMargin = (int) (i3 * 0.2d);
        this.d.setLayoutParams(layoutParams4);
        this.plY = com.kascend.chushou.view.h5.b.b(h5Options, new com.kascend.chushou.widget.cswebview.a().a(new JSInterface(this.b)).a(new d() { // from class: com.kascend.chushou.player.ui.h5.redpacket.c.2
            @Override // com.kascend.chushou.widget.cswebview.d
            public void a(Object obj) {
                c.this.dismissAllowingStateLoss();
            }

            @Override // com.kascend.chushou.widget.cswebview.d
            public void a(String str) {
            }
        }));
        getChildFragmentManager().beginTransaction().add(a.f.dialog_send_redpacket_container, this.plY).commitAllowingStateLoss();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kascend.chushou.player.ui.h5.redpacket.c.3
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
                    return i4 == 4 && c.this.plY != null && c.this.plY.isAdded() && c.this.plY.a(i4, keyEvent);
                }
            });
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (tv.chushou.zues.utils.a.hD(this.b).x * ((1.0d * this.pkQ.mWidth) / 100.0d));
            attributes.height = -1;
            window.setAttributes(attributes);
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        tv.chushou.zues.a.a.ct(this);
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(getActivity());
        super.onDestroyView();
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!b() && bVar.f4150a == 7 && this.plY != null && this.plY.isAdded()) {
            this.plY.a("closeFloppyDisk()");
        }
    }

    public void a(ConfigDetail configDetail) {
        this.plZ = (ConfigDetail) tv.chushou.a.a.a.c.checkNotNull(configDetail);
    }
}
