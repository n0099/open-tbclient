package com.kascend.chushou.widget.gifts;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.ResponseCode;
import com.baidu.mapapi.UIMsg;
import com.kascend.chushou.a;
import java.util.ArrayList;
import java.util.List;
import tv.chushou.zues.widget.adapterview.recyclerview.a.a;
/* loaded from: classes5.dex */
public class b extends PopupWindow implements View.OnClickListener {
    private static final int[] b = {6666, ResponseCode.MCASAT_SEND_MSG_COLSE_ROOM, UIMsg.m_AppUI.MSG_PLACEFIELD_RELOAD, Opcodes.NEWARRAY, 66, 10, 1};
    private static final int[] c = {a.i.str_gift_count_6666, a.i.str_gift_count_1314, a.i.str_gift_count_520, a.i.str_gift_count_188, a.i.str_gift_count_66, a.i.str_gift_count_10, a.i.str_gift_count_1};
    private List<Pair<String, String>> a;
    private a nzt;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, int i);
    }

    public b(Context context, a aVar) {
        super(context);
        this.a = new ArrayList();
        View inflate = LayoutInflater.from(context).inflate(a.h.popup_gift_count, (ViewGroup) null, false);
        setContentView(inflate);
        this.nzt = aVar;
        inflate.findViewById(a.f.tv_customize).setOnClickListener(this);
        for (int i = 0; i < b.length; i++) {
            this.a.add(new Pair<>(String.valueOf(b[i]), context.getString(c[i])));
        }
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(a.f.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new tv.chushou.zues.widget.adapterview.recyclerview.a.a<Pair<String, String>>(this.a, a.h.item_gift_count, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.widget.gifts.b.1
            @Override // tv.chushou.zues.widget.adapterview.d
            public void B(View view, int i2) {
                Pair pair = (Pair) b.this.a.get(i2);
                if (b.this.nzt != null) {
                    b.this.nzt.a(false, Integer.parseInt((String) pair.first));
                }
                b.this.dismiss();
            }
        }) { // from class: com.kascend.chushou.widget.gifts.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC0940a view$OnLongClickListenerC0940a, Pair<String, String> pair) {
                view$OnLongClickListenerC0940a.a(a.f.tv_count, (CharSequence) pair.first);
                ((TextView) view$OnLongClickListenerC0940a.or(a.f.tv_desc)).setText((CharSequence) pair.second);
            }
        });
        setWidth(tv.chushou.zues.utils.a.dip2px(context, 160.0f));
        setHeight(tv.chushou.zues.utils.a.dip2px(context, ((this.a.size() + 2) * 30) + 50));
        setOutsideTouchable(true);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.tv_customize) {
            dismiss();
            if (this.nzt != null) {
                this.nzt.a(true, -1);
            }
        }
    }
}
