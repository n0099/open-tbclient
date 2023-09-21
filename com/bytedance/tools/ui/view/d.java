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
import com.baidu.tieba.nnb;
import com.baidu.tieba.onb;
import com.baidu.tieba.ynb;
import com.baidu.tieba.znb;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends com.bytedance.tools.ui.view.c {
    public View g;
    public View h;
    public TextView i;
    public TextView j;
    public nnb k;
    public onb l;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ List a;

        /* renamed from: com.bytedance.tools.ui.view.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C0565a implements AdapterView.OnItemClickListener {
            public final /* synthetic */ ynb a;

            public C0565a(a aVar, ynb ynbVar) {
                this.a = ynbVar;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                this.a.b(i);
            }
        }

        /* loaded from: classes9.dex */
        public class b implements View.OnClickListener {
            public final /* synthetic */ ynb a;

            public b(ynb ynbVar) {
                this.a = ynbVar;
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
            ynb ynbVar = new ynb(d.this.getContext(), this.a);
            d.this.i(ynbVar, new C0565a(this, ynbVar), new b(ynbVar));
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public final /* synthetic */ List a;

        /* loaded from: classes9.dex */
        public class a implements AdapterView.OnItemClickListener {
            public final /* synthetic */ znb a;

            public a(b bVar, znb znbVar) {
                this.a = znbVar;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                this.a.b(i);
            }
        }

        /* renamed from: com.bytedance.tools.ui.view.d$b$b  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class View$OnClickListenerC0566b implements View.OnClickListener {
            public final /* synthetic */ znb a;

            public View$OnClickListenerC0566b(znb znbVar) {
                this.a = znbVar;
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
            znb znbVar = new znb(d.this.getContext(), new ArrayList());
            for (int i = 0; i < this.a.size(); i++) {
                if (((nnb) this.a.get(i)).b(d.this.k)) {
                    znbVar.c(((nnb) this.a.get(i)).e());
                    d.this.i(znbVar, new a(this, znbVar), new View$OnClickListenerC0566b(znbVar));
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
    public class View$OnClickListenerC0567d implements View.OnClickListener {
        public final /* synthetic */ View.OnClickListener a;
        public final /* synthetic */ Dialog b;

        public View$OnClickListenerC0567d(View.OnClickListener onClickListener, Dialog dialog) {
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

    public d(Context context, RadioGroup radioGroup, nnb nnbVar, List<nnb> list) {
        super(context, radioGroup, nnbVar, list);
        setTitle("选择广告类型");
        setId(66666688);
    }

    @Override // com.bytedance.tools.ui.view.c
    public void b(RadioGroup radioGroup, nnb nnbVar, List<nnb> list) {
        super.b(radioGroup, nnbVar, list);
        LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0561, this.d);
        this.g = findViewById(R.id.obfuscated_res_0x7f091f5a);
        this.h = findViewById(R.id.obfuscated_res_0x7f091f5c);
        this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f091f5b);
        this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f091f5d);
        o();
        this.g.setOnClickListener(new a(list));
        this.h.setOnClickListener(new b(list));
    }

    @Override // com.bytedance.tools.ui.view.c
    public boolean d() {
        String str;
        nnb nnbVar = this.k;
        String str2 = "";
        if (nnbVar == null) {
            str = "";
        } else {
            str = nnbVar.a();
        }
        onb onbVar = this.l;
        if (onbVar != null) {
            str2 = onbVar.a();
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && TextUtils.getTrimmedLength(str) == 16 && TextUtils.getTrimmedLength(str2) == 16) {
            return false;
        }
        return true;
    }

    @Override // com.bytedance.tools.ui.view.c
    public nnb getConfigModel() {
        String str;
        nnb nnbVar = this.k;
        String str2 = "";
        if (nnbVar == null) {
            str = "";
        } else {
            str = nnbVar.a();
        }
        onb onbVar = this.l;
        if (onbVar != null) {
            str2 = onbVar.a();
        }
        return new nnb(str, str2);
    }

    public void h() {
        this.i.setText("");
        this.j.setText("");
    }

    public boolean m() {
        List<nnb> list = this.f;
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
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0562, (ViewGroup) null);
        ListView listView = (ListView) inflate.findViewById(R.id.obfuscated_res_0x7f091d39);
        listView.setAdapter((ListAdapter) baseAdapter);
        listView.setOnItemClickListener(onItemClickListener);
        inflate.findViewById(R.id.obfuscated_res_0x7f091d37).setOnClickListener(new c(dialog));
        inflate.findViewById(R.id.obfuscated_res_0x7f091d38).setOnClickListener(new View$OnClickListenerC0567d(onClickListener, dialog));
        dialog.setContentView(inflate);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        layoutParams.width = getResources().getDisplayMetrics().widthPixels;
        inflate.setLayoutParams(layoutParams);
        dialog.getWindow().setGravity(80);
        dialog.getWindow().setWindowAnimations(R.style.obfuscated_res_0x7f1003d0);
        dialog.show();
    }

    public final void o() {
        List<nnb> list = this.f;
        if (list != null && list.size() != 0) {
            for (int i = 0; i < this.f.size(); i++) {
                if (this.f.get(i).b(this.e)) {
                    nnb nnbVar = this.f.get(i);
                    this.k = nnbVar;
                    this.i.setText(nnbVar.f());
                    if (this.k.e() != null && this.k.e().size() != 0) {
                        for (int i2 = 0; i2 < this.k.e().size(); i2++) {
                            if (this.k.e().get(i2).a().equals(this.e.d())) {
                                onb onbVar = this.k.e().get(i2);
                                this.l = onbVar;
                                this.j.setText(onbVar.c());
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
