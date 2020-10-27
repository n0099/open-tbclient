package com.kascend.chushou.widget.gifts;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.kascend.chushou.a;
import java.util.ArrayList;
import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class a extends PopupWindow implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f4281a;
    private InterfaceC1003a psQ;

    /* renamed from: com.kascend.chushou.widget.gifts.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1003a {
        void a(int i);

        void b(int i);
    }

    public a(Context context, boolean z) {
        super(context);
        View inflate = LayoutInflater.from(context).inflate(a.h.popup_customize_count, (ViewGroup) null, false);
        setContentView(inflate);
        this.f4281a = (TextView) inflate.findViewById(a.f.tv_num);
        ImageView imageView = (ImageView) inflate.findViewById(a.f.iv_x);
        imageView.setOnClickListener(this);
        ArrayList<TextView> arrayList = new ArrayList();
        arrayList.add((TextView) inflate.findViewById(a.f.tv_1));
        arrayList.add((TextView) inflate.findViewById(a.f.tv_2));
        arrayList.add((TextView) inflate.findViewById(a.f.tv_3));
        arrayList.add((TextView) inflate.findViewById(a.f.tv_4));
        arrayList.add((TextView) inflate.findViewById(a.f.tv_5));
        arrayList.add((TextView) inflate.findViewById(a.f.tv_6));
        arrayList.add((TextView) inflate.findViewById(a.f.tv_7));
        arrayList.add((TextView) inflate.findViewById(a.f.tv_8));
        arrayList.add((TextView) inflate.findViewById(a.f.tv_9));
        arrayList.add((TextView) inflate.findViewById(a.f.tv_0));
        arrayList.add((TextView) inflate.findViewById(a.f.tv_confirm));
        for (TextView textView : arrayList) {
            textView.setOnClickListener(this);
        }
        if (z) {
            setWidth(tv.chushou.zues.utils.a.hD(context).x);
        } else {
            inflate.findViewById(a.f.space_1).setVisibility(8);
            ((LinearLayout) inflate.findViewById(a.f.ll_keyboard)).setBackgroundColor(Color.parseColor("#4A4A4A"));
            for (TextView textView2 : arrayList) {
                textView2.setTextColor(-1);
                textView2.setBackgroundColor(Color.parseColor("#3B3B3B"));
            }
            imageView.setBackgroundColor(Color.parseColor("#3B3B3B"));
            imageView.setImageResource(a.e.icon_delete_white);
            this.f4281a.setVisibility(8);
            setWidth(tv.chushou.zues.utils.a.dip2px(context, 260.0f));
        }
        setHeight(-2);
        setOutsideTouchable(true);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.tv_1) {
            a(1);
        } else if (id == a.f.tv_2) {
            a(2);
        } else if (id == a.f.tv_3) {
            a(3);
        } else if (id == a.f.tv_4) {
            a(4);
        } else if (id == a.f.tv_5) {
            a(5);
        } else if (id == a.f.tv_6) {
            a(6);
        } else if (id == a.f.tv_7) {
            a(7);
        } else if (id == a.f.tv_8) {
            a(8);
        } else if (id == a.f.tv_9) {
            a(9);
        } else if (id == a.f.tv_0) {
            a(0);
        } else if (id == a.f.iv_x) {
            b();
        } else if (id == a.f.tv_confirm) {
            a();
        }
    }

    private void a() {
        int parseInt = h.parseInt(this.f4281a.getText().toString());
        if (parseInt != 0) {
            dismiss();
            if (this.psQ != null) {
                this.psQ.a(parseInt);
            }
        }
    }

    private void a(int i) {
        int parseInt;
        String charSequence = this.f4281a.getText().toString();
        if (h.parseInt(charSequence) == 0) {
            this.f4281a.setText(String.valueOf(i));
        } else if (charSequence.length() < 4) {
            this.f4281a.setText(String.valueOf(charSequence + i));
        }
        if (this.psQ != null && (parseInt = h.parseInt(this.f4281a.getText().toString())) != 0) {
            this.psQ.b(parseInt);
        }
    }

    private void b() {
        int parseInt;
        String charSequence = this.f4281a.getText().toString();
        if (charSequence.length() > 0) {
            this.f4281a.setText(charSequence.substring(0, charSequence.length() - 1));
        }
        if (this.psQ != null && (parseInt = h.parseInt(this.f4281a.getText().toString())) != 0) {
            this.psQ.b(parseInt);
        }
    }

    public void a(InterfaceC1003a interfaceC1003a) {
        this.psQ = interfaceC1003a;
    }
}
