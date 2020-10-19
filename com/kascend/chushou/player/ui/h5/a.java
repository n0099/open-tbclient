package com.kascend.chushou.player.ui.h5;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.JSInterface;
import com.kascend.chushou.view.h5.H5Options;
import java.util.HashMap;
import kotlin.h;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import tv.chushou.basis.rxjava.annotation.Subscribe;
@h
/* loaded from: classes6.dex */
public final class a extends com.kascend.chushou.view.base.a {
    public static final C0909a otN = new C0909a(null);
    private int f = tv.chushou.widget.a.c.J(300.0f);
    private int g = tv.chushou.widget.a.c.J(400.0f);
    private HashMap h;
    private com.kascend.chushou.view.h5.b otL;
    private com.kascend.chushou.toolkit.b otM;

    public void a() {
        if (this.h != null) {
            this.h.clear();
        }
    }

    @h
    /* renamed from: com.kascend.chushou.player.ui.h5.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0909a {
        public final a Wr(String str) {
            return a(this, str, false, null, 0, 0, 30, null);
        }

        private C0909a() {
        }

        public /* synthetic */ C0909a(o oVar) {
            this();
        }

        public static /* synthetic */ a a(C0909a c0909a, String str, boolean z, com.kascend.chushou.toolkit.b bVar, int i, int i2, int i3, Object obj) {
            return c0909a.a(str, (i3 & 2) != 0 ? true : z, (i3 & 4) != 0 ? null : bVar, (i3 & 8) != 0 ? tv.chushou.widget.a.c.J(300.0f) : i, (i3 & 16) != 0 ? tv.chushou.widget.a.c.J(400.0f) : i2);
        }

        public final a a(String str, boolean z, com.kascend.chushou.toolkit.b bVar, int i, int i2) {
            a aVar = new a();
            aVar.otM = bVar;
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putBoolean("canceledOutside", z);
            bundle.putInt("width", i);
            bundle.putInt("height", i2);
            aVar.setArguments(bundle);
            return aVar;
        }
    }

    @Override // com.kascend.chushou.view.base.a, android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        Bundle arguments = getArguments();
        boolean z = arguments != null ? arguments.getBoolean("canceledOutside", false) : false;
        Bundle arguments2 = getArguments();
        this.f = arguments2 != null ? arguments2.getInt("width", tv.chushou.widget.a.c.J(300.0f)) : tv.chushou.widget.a.c.J(300.0f);
        Bundle arguments3 = getArguments();
        this.g = arguments3 != null ? arguments3.getInt("height", tv.chushou.widget.a.c.J(400.0f)) : tv.chushou.widget.a.c.J(400.0f);
        onCreateDialog.setCanceledOnTouchOutside(z);
        q.m(onCreateDialog, "dialog");
        return onCreateDialog;
    }

    @Override // com.kascend.chushou.view.base.a
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        q.n(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(a.h.dialog_fixed_size_h5, viewGroup, false);
        tv.chushou.zues.a.a.register(this);
        q.m(inflate, "v");
        return inflate;
    }

    @Override // com.kascend.chushou.view.base.a
    public void a(View view) {
        q.n(view, "v");
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("url") : null;
        if (TextUtils.isEmpty(string)) {
            dismissAllowingStateLoss();
            return;
        }
        H5Options h5Options = new H5Options();
        h5Options.e = true;
        h5Options.h = 0;
        h5Options.c = false;
        h5Options.b = true;
        h5Options.f4233a = string;
        h5Options.d = true;
        h5Options.f = false;
        com.kascend.chushou.widget.cswebview.a a2 = new com.kascend.chushou.widget.cswebview.a().a(new JSInterface(this.b)).a(new c());
        if (this.otM != null) {
            q.m(a2, "extra");
            a2.a(this.otM);
        }
        this.otL = com.kascend.chushou.view.h5.b.b(h5Options, a2);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        int i = a.f.fl_container;
        com.kascend.chushou.view.h5.b bVar = this.otL;
        if (bVar == null) {
            q.eob();
        }
        beginTransaction.add(i, bVar).commitAllowingStateLoss();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnKeyListener(new b());
        }
    }

    @h
    /* loaded from: classes6.dex */
    public static final class c implements com.kascend.chushou.widget.cswebview.d {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        c() {
        }

        @Override // com.kascend.chushou.widget.cswebview.d
        public void a(Object obj) {
            a.this.dismissAllowingStateLoss();
        }

        @Override // com.kascend.chushou.widget.cswebview.d
        public void a(String str) {
            q.n(str, "id");
        }
    }

    @h
    /* loaded from: classes6.dex */
    public static final class b implements DialogInterface.OnKeyListener {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        b() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            com.kascend.chushou.view.h5.b bVar;
            com.kascend.chushou.view.h5.b bVar2 = a.this.otL;
            return bVar2 != null && bVar2.isAdded() && (bVar = a.this.otL) != null && bVar.a(i, keyEvent);
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        c();
    }

    private final void c() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Resources resources = getResources();
            q.m(resources, "this.resources");
            if (resources.getConfiguration().orientation == 1) {
                attributes.width = this.f;
                attributes.height = this.g;
            } else {
                Point hk = tv.chushou.zues.utils.a.hk(this.b);
                attributes.width = tv.chushou.zues.utils.a.dip2px(this.b, 300.0f);
                attributes.height = hk.y;
            }
            window.setAttributes(attributes);
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c();
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        tv.chushou.zues.a.a.cp(this);
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(getActivity());
        super.onDestroyView();
        a();
    }

    @Subscribe
    public final void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        q.n(bVar, NotificationCompat.CATEGORY_EVENT);
        if (b() || bVar.f4152a != 7 || this.otL == null) {
            return;
        }
        com.kascend.chushou.view.h5.b bVar2 = this.otL;
        if (bVar2 == null) {
            q.eob();
        }
        if (bVar2.isAdded()) {
            com.kascend.chushou.view.h5.b bVar3 = this.otL;
            if (bVar3 == null) {
                q.eob();
            }
            bVar3.a("closeFloppyDisk()");
        }
    }
}
