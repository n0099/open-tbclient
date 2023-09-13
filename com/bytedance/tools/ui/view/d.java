package com.bytedance.tools.ui.view;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tieba.R;
import com.baidu.tieba.gmb;
import com.baidu.tieba.hmb;
import com.baidu.tieba.vlb;
import com.baidu.tieba.wlb;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends com.bytedance.tools.ui.view.c {
    public View g;
    public View h;
    public TextView i;
    public TextView j;
    public vlb k;
    public wlb l;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ List a;

        /* renamed from: com.bytedance.tools.ui.view.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C0572a implements AdapterView.OnItemClickListener {
            public final /* synthetic */ gmb a;

            public C0572a(a aVar, gmb gmbVar) {
                this.a = gmbVar;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                this.a.b(i);
            }
        }

        /* loaded from: classes9.dex */
        public class b implements View.OnClickListener {
            public final /* synthetic */ gmb a;

            public b(gmb gmbVar) {
                this.a = gmbVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (this.a.a() != null) {
                    if (!this.a.a().b(d.this.k)) {
                        d.this.k = this.a.a();
                        d.this.l = null;
                        d.this.j.setText("");
                    }
                    d.this.i.setText(d.this.k.f());
                }
            }
        }

        public a(List list) {
            this.a = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            gmb gmbVar = new gmb(d.this.getContext(), this.a);
            d.this.i(gmbVar, new C0572a(this, gmbVar), new b(gmbVar));
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public final /* synthetic */ List a;

        /* loaded from: classes9.dex */
        public class a implements AdapterView.OnItemClickListener {
            public final /* synthetic */ hmb a;

            public a(b bVar, hmb hmbVar) {
                this.a = hmbVar;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                this.a.b(i);
            }
        }

        /* renamed from: com.bytedance.tools.ui.view.d$b$b  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class View$OnClickListenerC0573b implements View.OnClickListener {
            public final /* synthetic */ hmb a;

            public View$OnClickListenerC0573b(hmb hmbVar) {
                this.a = hmbVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (this.a.a() != null) {
                    d.this.l = this.a.a();
                    d.this.j.setText(d.this.l.c());
                }
            }
        }

        public b(List list) {
            this.a = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            hmb hmbVar = new hmb(d.this.getContext(), new ArrayList());
            for (int i = 0; i < this.a.size(); i++) {
                if (((vlb) this.a.get(i)).b(d.this.k)) {
                    hmbVar.c(((vlb) this.a.get(i)).e());
                    d.this.i(hmbVar, new a(this, hmbVar), new View$OnClickListenerC0573b(hmbVar));
                    return;
                }
            }
            Toast.makeText(d.this.getContext(), "请先选中aid，再选择cid", 0).show();
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public final /* synthetic */ Dialog a;

        public c(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            this.a.dismiss();
        }
    }

    /* renamed from: com.bytedance.tools.ui.view.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC0574d implements View.OnClickListener {
        public final /* synthetic */ View.OnClickListener a;
        public final /* synthetic */ Dialog b;

        public View$OnClickListenerC0574d(View.OnClickListener onClickListener, Dialog dialog) {
            this.a = onClickListener;
            this.b = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            View.OnClickListener onClickListener = this.a;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
            this.b.dismiss();
        }
    }

    public d(Context context, RadioGroup radioGroup, vlb vlbVar, List<vlb> list) {
        super(context, radioGroup, vlbVar, list);
        setTitle("选择广告类型");
        setId(66666688);
    }

    @Override // com.bytedance.tools.ui.view.c
    public void b(RadioGroup radioGroup, vlb vlbVar, List<vlb> list) {
        super.b(radioGroup, vlbVar, list);
        LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d055f, this.d);
        this.g = findViewById(R.id.obfuscated_res_0x7f091f91);
        this.h = findViewById(R.id.obfuscated_res_0x7f091f93);
        this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f091f92);
        this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f091f94);
        o();
        this.g.setOnClickListener(new a(list));
        this.h.setOnClickListener(new b(list));
    }

    @Override // com.bytedance.tools.ui.view.c
    public boolean d() {
        String str;
        vlb vlbVar = this.k;
        String str2 = "";
        if (vlbVar == null) {
            str = "";
        } else {
            str = vlbVar.a();
        }
        wlb wlbVar = this.l;
        if (wlbVar != null) {
            str2 = wlbVar.a();
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && TextUtils.getTrimmedLength(str) == 16 && TextUtils.getTrimmedLength(str2) == 16) {
            return false;
        }
        return true;
    }

    @Override // com.bytedance.tools.ui.view.c
    public vlb getConfigModel() {
        String str;
        vlb vlbVar = this.k;
        String str2 = "";
        if (vlbVar == null) {
            str = "";
        } else {
            str = vlbVar.a();
        }
        wlb wlbVar = this.l;
        if (wlbVar != null) {
            str2 = wlbVar.a();
        }
        return new vlb(str, str2);
    }

    public void h() {
        this.i.setText("");
        this.j.setText("");
    }

    public boolean m() {
        List<vlb> list = this.f;
        if (list != null && list.size() != 0) {
            for (int i = 0; i < this.f.size(); i++) {
                if (this.f.get(i).b(this.e)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void i(BaseAdapter baseAdapter, AdapterView.OnItemClickListener onItemClickListener, View.OnClickListener onClickListener) {
        Dialog dialog = new Dialog(getContext(), R.style.obfuscated_res_0x7f1000fb);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0560, (ViewGroup) null);
        ListView listView = (ListView) inflate.findViewById(R.id.obfuscated_res_0x7f091d6b);
        listView.setAdapter((ListAdapter) baseAdapter);
        listView.setOnItemClickListener(onItemClickListener);
        inflate.findViewById(R.id.obfuscated_res_0x7f091d69).setOnClickListener(new c(dialog));
        inflate.findViewById(R.id.obfuscated_res_0x7f091d6a).setOnClickListener(new View$OnClickListenerC0574d(onClickListener, dialog));
        dialog.setContentView(inflate);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        layoutParams.width = getResources().getDisplayMetrics().widthPixels;
        inflate.setLayoutParams(layoutParams);
        dialog.getWindow().setGravity(80);
        dialog.getWindow().setWindowAnimations(R.style.obfuscated_res_0x7f1003ce);
        dialog.show();
    }

    public final void o() {
        List<vlb> list = this.f;
        if (list != null && list.size() != 0) {
            for (int i = 0; i < this.f.size(); i++) {
                if (this.f.get(i).b(this.e)) {
                    vlb vlbVar = this.f.get(i);
                    this.k = vlbVar;
                    this.i.setText(vlbVar.f());
                    if (this.k.e() != null && this.k.e().size() != 0) {
                        for (int i2 = 0; i2 < this.k.e().size(); i2++) {
                            if (this.k.e().get(i2).a().equals(this.e.d())) {
                                wlb wlbVar = this.k.e().get(i2);
                                this.l = wlbVar;
                                this.j.setText(wlbVar.c());
                                return;
                            }
                        }
                        continue;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
