package com.kascend.chushou.view.b.a;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kascend.chushou.a;
import tv.chushou.zues.utils.systemBar.b;
/* loaded from: classes5.dex */
public class a extends com.kascend.chushou.view.base.a implements View.OnClickListener {
    public int a = 0;
    private RelativeLayout d;
    private ImageView e;
    private View f;
    private TextView g;
    private TextView h;
    private InterfaceC0714a nfh;

    /* renamed from: com.kascend.chushou.view.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0714a {
        void a(int i);
    }

    public static a dEo() {
        return new a();
    }

    @Override // com.kascend.chushou.view.base.a, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, 16973841);
        this.a++;
    }

    @Override // com.kascend.chushou.view.base.a, android.support.v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setCanceledOnTouchOutside(false);
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        return onCreateDialog;
    }

    @Override // com.kascend.chushou.view.base.a
    public View b(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int statusBarHeight = b.getStatusBarHeight(this.b);
        View inflate = layoutInflater.inflate(a.h.view_playshow_4g_info, viewGroup, false);
        this.d = (RelativeLayout) inflate.findViewById(a.f.rl_close);
        this.e = (ImageView) inflate.findViewById(a.f.iv_close);
        if (statusBarHeight > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.d.setLayoutParams(layoutParams);
        }
        this.f = inflate.findViewById(a.f.view);
        this.g = (TextView) inflate.findViewById(a.f.tv_play_video);
        this.h = (TextView) inflate.findViewById(a.f.tv_play_audio);
        this.h.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        View findViewById = inflate.findViewById(a.f.tv_union_proxy);
        findViewById.setOnClickListener(this);
        findViewById.setVisibility(8);
        return inflate;
    }

    @Override // com.kascend.chushou.view.base.a
    public void a(View view) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.nfh != null) {
            this.nfh.a(view.getId());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.a--;
    }

    public void a(InterfaceC0714a interfaceC0714a) {
        this.nfh = interfaceC0714a;
    }
}
