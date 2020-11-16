package com.kascend.chushou.view.b;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kascend.chushou.a;
import java.util.HashMap;
import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class b extends com.kascend.chushou.view.base.a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextView f4227a;
    private TextView d;
    private String e;

    public static b Yy(String str) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString("dataInfo", str);
        bVar.setArguments(bundle);
        return bVar;
    }

    @Override // com.kascend.chushou.view.base.a, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.e = getArguments().getString("dataInfo", "");
        }
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
        View inflate = layoutInflater.inflate(a.h.dialog_recharge, viewGroup, false);
        this.f4227a = (TextView) inflate.findViewById(a.f.tv_recharge);
        this.d = (TextView) inflate.findViewById(a.f.tv_cancel);
        this.d.setOnClickListener(this);
        this.f4227a.setOnClickListener(this);
        return inflate;
    }

    @Override // com.kascend.chushou.view.base.a
    public void a(View view) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.tv_recharge) {
            dismissAllowingStateLoss();
            HashMap hashMap = new HashMap();
            if (!h.isEmpty(this.e)) {
                hashMap.putAll(tv.chushou.zues.utils.d.aan(this.e));
            }
            hashMap.put("_fromView", "58");
            com.kascend.chushou.d.a.c(this.b, tv.chushou.zues.utils.d.toJson(hashMap));
        } else if (id == a.f.tv_cancel) {
            dismissAllowingStateLoss();
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        a(tv.chushou.zues.utils.a.dip2px(this.b, 300.0f), -2);
    }
}
