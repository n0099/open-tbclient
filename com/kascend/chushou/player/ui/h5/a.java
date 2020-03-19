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
/* loaded from: classes5.dex */
public final class a extends com.kascend.chushou.view.base.a {
    public static final C0703a ndU = new C0703a(null);
    private int f = tv.chushou.widget.a.c.S(300.0f);
    private int g = tv.chushou.widget.a.c.S(400.0f);
    private HashMap h;
    private com.kascend.chushou.view.h5.b ndS;
    private com.kascend.chushou.toolkit.b ndT;

    public void a() {
        if (this.h != null) {
            this.h.clear();
        }
    }

    @h
    /* renamed from: com.kascend.chushou.player.ui.h5.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0703a {
        public final a QX(String str) {
            return a(this, str, false, null, 0, 0, 30, null);
        }

        private C0703a() {
        }

        public /* synthetic */ C0703a(o oVar) {
            this();
        }

        public static /* synthetic */ a a(C0703a c0703a, String str, boolean z, com.kascend.chushou.toolkit.b bVar, int i, int i2, int i3, Object obj) {
            return c0703a.a(str, (i3 & 2) != 0 ? true : z, (i3 & 4) != 0 ? null : bVar, (i3 & 8) != 0 ? tv.chushou.widget.a.c.S(300.0f) : i, (i3 & 16) != 0 ? tv.chushou.widget.a.c.S(400.0f) : i2);
        }

        public final a a(String str, boolean z, com.kascend.chushou.toolkit.b bVar, int i, int i2) {
            a aVar = new a();
            aVar.ndT = bVar;
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
        this.f = arguments2 != null ? arguments2.getInt("width", tv.chushou.widget.a.c.S(300.0f)) : tv.chushou.widget.a.c.S(300.0f);
        Bundle arguments3 = getArguments();
        this.g = arguments3 != null ? arguments3.getInt("height", tv.chushou.widget.a.c.S(400.0f)) : tv.chushou.widget.a.c.S(400.0f);
        onCreateDialog.setCanceledOnTouchOutside(z);
        q.i(onCreateDialog, "dialog");
        return onCreateDialog;
    }

    @Override // com.kascend.chushou.view.base.a
    public View b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        q.j(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(a.h.dialog_fixed_size_h5, viewGroup, false);
        tv.chushou.zues.a.a.register(this);
        q.i(inflate, "v");
        return inflate;
    }

    @Override // com.kascend.chushou.view.base.a
    public void a(View view) {
        q.j(view, "v");
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
        h5Options.a = string;
        h5Options.d = true;
        h5Options.f = false;
        com.kascend.chushou.widget.cswebview.a a = new com.kascend.chushou.widget.cswebview.a().a(new JSInterface(this.b)).a(new c());
        if (this.ndT != null) {
            q.i(a, "extra");
            a.a(this.ndT);
        }
        this.ndS = com.kascend.chushou.view.h5.b.b(h5Options, a);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        int i = a.f.fl_container;
        com.kascend.chushou.view.h5.b bVar = this.ndS;
        if (bVar == null) {
            q.dKW();
        }
        beginTransaction.add(i, bVar).commitAllowingStateLoss();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnKeyListener(new b());
        }
    }

    @h
    /* loaded from: classes5.dex */
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
            q.j(str, "id");
        }
    }

    @h
    /* loaded from: classes5.dex */
    public static final class b implements DialogInterface.OnKeyListener {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        b() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            com.kascend.chushou.view.h5.b bVar;
            com.kascend.chushou.view.h5.b bVar2 = a.this.ndS;
            return bVar2 != null && bVar2.isAdded() && (bVar = a.this.ndS) != null && bVar.a(i, keyEvent);
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
            q.i(resources, "this.resources");
            if (resources.getConfiguration().orientation == 1) {
                attributes.width = this.f;
                attributes.height = this.g;
            } else {
                Point hd = tv.chushou.zues.utils.a.hd(this.b);
                attributes.width = tv.chushou.zues.utils.a.dip2px(this.b, 300.0f);
                attributes.height = hd.y;
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
        tv.chushou.zues.a.a.cr(this);
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(getActivity());
        super.onDestroyView();
        a();
    }

    @Subscribe
    public final void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        q.j(bVar, NotificationCompat.CATEGORY_EVENT);
        if (b() || bVar.a != 7 || this.ndS == null) {
            return;
        }
        com.kascend.chushou.view.h5.b bVar2 = this.ndS;
        if (bVar2 == null) {
            q.dKW();
        }
        if (bVar2.isAdded()) {
            com.kascend.chushou.view.h5.b bVar3 = this.ndS;
            if (bVar3 == null) {
                q.dKW();
            }
            bVar3.a("closeFloppyDisk()");
        }
    }
}
