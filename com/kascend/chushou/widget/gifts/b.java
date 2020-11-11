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
import com.kascend.chushou.a;
import java.util.ArrayList;
import java.util.List;
import tv.chushou.zues.widget.adapterview.recyclerview.a.a;
/* loaded from: classes6.dex */
public class b extends PopupWindow implements View.OnClickListener {
    private static final int[] b = {6666, ResponseCode.MCASAT_SEND_MSG_COLSE_ROOM, 520, Opcodes.NEWARRAY, 66, 10, 1};
    private static final int[] c = {a.i.str_gift_count_6666, a.i.str_gift_count_1314, a.i.str_gift_count_520, a.i.str_gift_count_188, a.i.str_gift_count_66, a.i.str_gift_count_10, a.i.str_gift_count_1};

    /* renamed from: a  reason: collision with root package name */
    private List<Pair<String, String>> f4285a;
    private a pCm;

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z, int i);
    }

    public b(Context context, a aVar) {
        super(context);
        this.f4285a = new ArrayList();
        View inflate = LayoutInflater.from(context).inflate(a.h.popup_gift_count, (ViewGroup) null, false);
        setContentView(inflate);
        this.pCm = aVar;
        inflate.findViewById(a.f.tv_customize).setOnClickListener(this);
        for (int i = 0; i < b.length; i++) {
            this.f4285a.add(new Pair<>(String.valueOf(b[i]), context.getString(c[i])));
        }
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(a.f.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new tv.chushou.zues.widget.adapterview.recyclerview.a.a<Pair<String, String>>(this.f4285a, a.h.item_gift_count, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.widget.gifts.b.1
            @Override // tv.chushou.zues.widget.adapterview.d
            public void I(View view, int i2) {
                Pair pair = (Pair) b.this.f4285a.get(i2);
                if (b.this.pCm != null) {
                    b.this.pCm.a(false, Integer.parseInt((String) pair.first));
                }
                b.this.dismiss();
            }
        }) { // from class: com.kascend.chushou.widget.gifts.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC1121a view$OnLongClickListenerC1121a, Pair<String, String> pair) {
                view$OnLongClickListenerC1121a.a(a.f.tv_count, (CharSequence) pair.first);
                ((TextView) view$OnLongClickListenerC1121a.sg(a.f.tv_desc)).setText((CharSequence) pair.second);
            }
        });
        setWidth(tv.chushou.zues.utils.a.dip2px(context, 160.0f));
        setHeight(tv.chushou.zues.utils.a.dip2px(context, ((this.f4285a.size() + 2) * 30) + 50));
        setOutsideTouchable(true);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.tv_customize) {
            dismiss();
            if (this.pCm != null) {
                this.pCm.a(true, -1);
            }
        }
    }
}
