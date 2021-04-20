package d.b.i0.v3.v.p;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.write.vote.WriteVoteActivity;
import com.baidu.tieba.write.write.vote.WriteVoteViewAdapter;
import d.b.c.e.p.l;
import d.b.h0.z0.i0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class b implements d.b.h0.t0.a, View.OnClickListener {
    public int A = 0;
    public int B = -1;
    public boolean C = false;
    public boolean D = false;
    public Intent E;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<WriteVoteActivity> f63609e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f63610f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f63611g;

    /* renamed from: h  reason: collision with root package name */
    public BdRecyclerView f63612h;
    public WriteVoteViewAdapter i;
    public LinearLayout j;
    public LinearLayout k;
    public TextView l;
    public EditText m;
    public List<WriteVoteItemData> n;
    public WriteVoteData o;
    public ForumWriteData p;
    public String q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public TextView z;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.J(b.this.f63609e.getPageActivity(), b.this.m);
        }
    }

    /* renamed from: d.b.i0.v3.v.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1690b implements TextWatcher {
        public C1690b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null) {
                return;
            }
            String obj = editable.toString();
            if (StringUtils.isNull(obj)) {
                b.this.m.setTypeface(Typeface.defaultFromStyle(0));
                b.this.C = false;
                b.this.K(false);
                return;
            }
            String replace = obj.replace(" ", "");
            if (i0.d(replace) > 40) {
                b.this.f63609e.showToast(String.format(b.this.f63609e.getString(R.string.write_vote_toast), 20));
            }
            String m = i0.m(replace, 40);
            if (!m.equals(editable.toString())) {
                b.this.m.setText(m);
                b.this.m.setSelection(m.length());
            }
            b.this.m.setTypeface(Typeface.defaultFromStyle(1));
            b.this.C = true;
            b bVar = b.this;
            bVar.K(bVar.D);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes5.dex */
    public class c implements WriteVoteViewAdapter.f {

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.i.setData(b.this.n);
            }
        }

        /* renamed from: d.b.i0.v3.v.p.b$c$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1691b implements Runnable {
            public RunnableC1691b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.i.setData(b.this.n);
            }
        }

        public c() {
        }

        @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.f
        public void a(int i) {
            b.this.n.remove(i);
            b.this.f63612h.post(new RunnableC1691b());
            b bVar = b.this;
            bVar.D = bVar.w();
            b bVar2 = b.this;
            bVar2.K(bVar2.C && b.this.D);
        }

        @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.f
        public void b() {
            b.this.n.add(new WriteVoteItemData());
            b.this.f63612h.post(new a());
            b bVar = b.this;
            bVar.D = bVar.w();
            b bVar2 = b.this;
            bVar2.K(bVar2.C && b.this.D);
        }

        @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.f
        public void c(WriteVoteItemData writeVoteItemData, int i) {
            b.this.n.set(i, writeVoteItemData);
            b bVar = b.this;
            bVar.D = bVar.w();
            b bVar2 = b.this;
            bVar2.K(bVar2.C && b.this.D);
        }
    }

    /* loaded from: classes5.dex */
    public class d extends RecyclerView.OnScrollListener {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 || i == 2) {
                l.w(b.this.f63609e.getPageActivity(), recyclerView);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            List<WriteVoteItemData> v = b.this.v();
            HashMap hashMap = new HashMap();
            int size = v.size();
            for (int i = 0; i < size; i++) {
                WriteVoteItemData writeVoteItemData = v.get(i);
                if (hashMap.containsKey(writeVoteItemData.getText())) {
                    b.this.f63609e.showToast(String.format(b.this.f63609e.getString(R.string.write_vote_repeat_toast), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i + 1)));
                    return;
                }
                hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i));
            }
            b.this.o = new WriteVoteData();
            b.this.o.setTitle(b.this.m.getText().toString());
            b.this.o.setExpire_type(b.this.B);
            b.this.o.setIs_multi(b.this.A);
            b.this.o.setOptions(v);
            b.this.E = new Intent();
            b.this.E.putExtra(IntentConfig.WRITE_VOTE_DATA, b.this.o);
            b.this.f63609e.getPageActivity().finish();
            b bVar = b.this;
            bVar.F(bVar.q);
        }
    }

    public b(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.f63609e = tbPageContext;
        this.f63610f = linearLayout;
        this.f63611g = navigationBar;
        Intent intent = tbPageContext.getPageActivity().getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra("extra_data");
            if (serializableExtra instanceof WriteVoteData) {
                this.o = (WriteVoteData) serializableExtra;
            } else if (serializableExtra instanceof ForumWriteData) {
                this.p = (ForumWriteData) serializableExtra;
            }
            this.q = intent.getStringExtra("title");
        }
        WriteVoteData writeVoteData = this.o;
        if (writeVoteData != null && !ListUtils.isEmpty(writeVoteData.getOptions()) && this.o.getOptions().size() >= 2) {
            this.n = this.o.getOptions();
        } else {
            ArrayList arrayList = new ArrayList();
            this.n = arrayList;
            arrayList.add(new WriteVoteItemData());
            this.n.add(new WriteVoteItemData());
        }
        x();
    }

    public final void A() {
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.m.addTextChangedListener(new C1690b());
        this.i.g(new c());
        this.f63612h.addOnScrollListener(new d());
        this.z.setOnClickListener(new e());
    }

    public final void B() {
        this.f63611g.setCenterTextTitle(this.f63609e.getResources().getString(R.string.write_add_vote));
        TextView addTextButton = this.f63611g.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f63609e.getResources().getString(R.string.done));
        this.z = addTextButton;
        addTextButton.setTextSize(0, l.g(this.f63609e.getPageActivity(), R.dimen.tbds44));
        this.z.setEnabled(false);
    }

    public final void E() {
        WriteVoteData writeVoteData = this.o;
        if (writeVoteData == null) {
            return;
        }
        this.m.setText(writeVoteData.getTitle());
        this.A = this.o.getIs_multi();
        this.B = this.o.getExpire_type();
        J();
        I();
        boolean w = w();
        this.D = w;
        K(this.C && w);
    }

    public final void F(String str) {
        if (this.p == null || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig.newInstance(this.f63609e.getPageActivity()).setType(9).setForumWriteData(this.p).setShowVoteData(this.o).setTitle(str).send();
    }

    public final void G(TextView textView, boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.f63609e.getResources().getDimension(R.dimen.tbds10));
        if (z) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0302);
            gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0905));
            textView.setBackgroundDrawable(gradientDrawable);
            return;
        }
        SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0209));
        textView.setBackgroundDrawable(gradientDrawable);
    }

    public final void I() {
        G(this.v, this.B == -1);
        G(this.w, this.B == 1);
        G(this.x, this.B == 7);
        G(this.y, this.B == 30);
    }

    public final void J() {
        G(this.s, this.A != 1);
        G(this.t, this.A == 1);
    }

    public final void K(boolean z) {
        this.z.setEnabled(z);
        if (z) {
            this.z.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
        } else {
            this.z.setTextColor(d.b.i0.d3.c.a(SkinManager.getColor(R.color.CAM_X0302), 0.5f));
        }
    }

    @Override // d.b.h0.t0.a
    public Intent getResultIntent() {
        return this.E;
    }

    @Override // d.b.h0.t0.a
    public boolean isOnViewCancel() {
        return true;
    }

    @Override // d.b.h0.t0.a
    public boolean isOnViewTop() {
        LinearLayout linearLayout = this.j;
        return linearLayout != null && this.f63612h != null && linearLayout.getTop() == 0 && this.f63612h.getFirstVisiblePosition() == 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.vote_type_single) {
            this.A = 0;
            J();
        } else if (view.getId() == R.id.vote_type_multiple) {
            this.A = 1;
            J();
        } else if (view.getId() == R.id.vote_time_forever) {
            this.B = -1;
            I();
        } else if (view.getId() == R.id.vote_time_1_day) {
            this.B = 1;
            I();
        } else if (view.getId() == R.id.vote_time_7_days) {
            this.B = 7;
            I();
        } else if (view.getId() == R.id.vote_time_30_days) {
            this.B = 30;
            I();
        }
    }

    @Override // d.b.h0.t0.a
    public void onViewChangeSkinType(int i) {
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0109);
        this.m.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
        this.m.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.r.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.u.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        if (this.C && this.D) {
            this.z.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
        } else {
            this.z.setTextColor(d.b.i0.d3.c.a(SkinManager.getColor(R.color.CAM_X0302), 0.5f));
        }
        J();
        I();
        WriteVoteViewAdapter writeVoteViewAdapter = this.i;
        if (writeVoteViewAdapter != null) {
            writeVoteViewAdapter.notifyDataSetChanged();
        }
    }

    public final List<WriteVoteItemData> v() {
        ArrayList arrayList = new ArrayList();
        List<WriteVoteItemData> list = this.n;
        if (list == null) {
            return arrayList;
        }
        int size = list.size();
        int i = 0;
        while (i < size) {
            WriteVoteItemData writeVoteItemData = new WriteVoteItemData();
            int i2 = i + 1;
            writeVoteItemData.setId(i2);
            writeVoteItemData.setText(this.n.get(i).getText());
            arrayList.add(writeVoteItemData);
            i = i2;
        }
        return arrayList;
    }

    public final boolean w() {
        int size = this.n.size();
        for (int i = 0; i < size; i++) {
            if (StringUtils.isNull(this.n.get(i).getText())) {
                return false;
            }
        }
        return true;
    }

    public final void x() {
        BdRecyclerView bdRecyclerView = new BdRecyclerView(this.f63609e.getPageActivity());
        this.f63612h = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(this.f63609e.getPageActivity()));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = l.g(this.f63609e.getPageActivity(), R.dimen.tbds27);
        this.f63610f.addView(this.f63612h, layoutParams);
        WriteVoteViewAdapter writeVoteViewAdapter = new WriteVoteViewAdapter(this.f63609e);
        this.i = writeVoteViewAdapter;
        this.f63612h.setAdapter(writeVoteViewAdapter);
        B();
        z();
        y();
        A();
        this.f63612h.s(this.j);
        this.f63612h.r(this.k);
        this.i.setData(this.n);
        E();
        this.m.requestFocus();
        this.m.postDelayed(new a(), 150L);
    }

    public final void y() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f63609e.getPageActivity()).inflate(R.layout.view_vote_footer, (ViewGroup) null);
        this.k = linearLayout;
        this.r = (TextView) linearLayout.findViewById(R.id.write_vote_type);
        this.s = (TextView) this.k.findViewById(R.id.vote_type_single);
        this.t = (TextView) this.k.findViewById(R.id.vote_type_multiple);
        this.u = (TextView) this.k.findViewById(R.id.write_vote_time);
        this.v = (TextView) this.k.findViewById(R.id.vote_time_forever);
        this.w = (TextView) this.k.findViewById(R.id.vote_time_1_day);
        this.x = (TextView) this.k.findViewById(R.id.vote_time_7_days);
        this.y = (TextView) this.k.findViewById(R.id.vote_time_30_days);
    }

    public final void z() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f63609e.getPageActivity()).inflate(R.layout.view_vote_header, (ViewGroup) null);
        this.j = linearLayout;
        this.l = (TextView) linearLayout.findViewById(R.id.vote_item_tip);
        this.m = (EditText) this.j.findViewById(R.id.vote_title);
    }
}
