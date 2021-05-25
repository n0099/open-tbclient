package d.a.n0.w3.u.p;

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
import d.a.c.e.p.l;
import d.a.m0.z0.i0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class b implements d.a.m0.t0.a, View.OnClickListener {
    public int A = 0;
    public int B = -1;
    public boolean C = false;
    public boolean D = false;
    public Intent E;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<WriteVoteActivity> f63112e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f63113f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f63114g;

    /* renamed from: h  reason: collision with root package name */
    public BdRecyclerView f63115h;

    /* renamed from: i  reason: collision with root package name */
    public WriteVoteViewAdapter f63116i;
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
            l.K(b.this.f63112e.getPageActivity(), b.this.m);
        }
    }

    /* renamed from: d.a.n0.w3.u.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1729b implements TextWatcher {
        public C1729b() {
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
                b.this.J(false);
                return;
            }
            String replace = obj.replace(" ", "");
            if (i0.d(replace) > 40) {
                b.this.f63112e.showToast(String.format(b.this.f63112e.getString(R.string.write_vote_toast), 20));
            }
            String m = i0.m(replace, 40);
            if (!m.equals(editable.toString())) {
                b.this.m.setText(m);
                b.this.m.setSelection(m.length());
            }
            b.this.m.setTypeface(Typeface.defaultFromStyle(1));
            b.this.C = true;
            b bVar = b.this;
            bVar.J(bVar.D);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
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
                b.this.f63116i.setData(b.this.n);
            }
        }

        /* renamed from: d.a.n0.w3.u.p.b$c$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1730b implements Runnable {
            public RunnableC1730b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f63116i.setData(b.this.n);
            }
        }

        public c() {
        }

        @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.f
        public void a(int i2) {
            b.this.n.remove(i2);
            b.this.f63115h.post(new RunnableC1730b());
            b bVar = b.this;
            bVar.D = bVar.v();
            b bVar2 = b.this;
            bVar2.J(bVar2.C && b.this.D);
        }

        @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.f
        public void b() {
            b.this.n.add(new WriteVoteItemData());
            b.this.f63115h.post(new a());
            b bVar = b.this;
            bVar.D = bVar.v();
            b bVar2 = b.this;
            bVar2.J(bVar2.C && b.this.D);
        }

        @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.f
        public void c(WriteVoteItemData writeVoteItemData, int i2) {
            b.this.n.set(i2, writeVoteItemData);
            b bVar = b.this;
            bVar.D = bVar.v();
            b bVar2 = b.this;
            bVar2.J(bVar2.C && b.this.D);
        }
    }

    /* loaded from: classes5.dex */
    public class d extends RecyclerView.OnScrollListener {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 1 || i2 == 2) {
                l.x(b.this.f63112e.getPageActivity(), recyclerView);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            List<WriteVoteItemData> u = b.this.u();
            HashMap hashMap = new HashMap();
            int size = u.size();
            for (int i2 = 0; i2 < size; i2++) {
                WriteVoteItemData writeVoteItemData = u.get(i2);
                if (hashMap.containsKey(writeVoteItemData.getText())) {
                    b.this.f63112e.showToast(String.format(b.this.f63112e.getString(R.string.write_vote_repeat_toast), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i2 + 1)));
                    return;
                }
                hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i2));
            }
            b.this.o = new WriteVoteData();
            b.this.o.setTitle(b.this.m.getText().toString());
            b.this.o.setExpire_type(b.this.B);
            b.this.o.setIs_multi(b.this.A);
            b.this.o.setOptions(u);
            b.this.E = new Intent();
            b.this.E.putExtra(IntentConfig.WRITE_VOTE_DATA, b.this.o);
            b.this.f63112e.getPageActivity().finish();
            b bVar = b.this;
            bVar.F(bVar.q);
        }
    }

    public b(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.f63112e = tbPageContext;
        this.f63113f = linearLayout;
        this.f63114g = navigationBar;
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
        w();
    }

    public final void A() {
        this.f63114g.setCenterTextTitle(this.f63112e.getResources().getString(R.string.write_add_vote));
        TextView addTextButton = this.f63114g.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f63112e.getResources().getString(R.string.done));
        this.z = addTextButton;
        addTextButton.setTextSize(0, l.g(this.f63112e.getPageActivity(), R.dimen.tbds44));
        this.z.setEnabled(false);
    }

    public final void B() {
        WriteVoteData writeVoteData = this.o;
        if (writeVoteData == null) {
            return;
        }
        this.m.setText(writeVoteData.getTitle());
        this.A = this.o.getIs_multi();
        this.B = this.o.getExpire_type();
        I();
        H();
        boolean v = v();
        this.D = v;
        J(this.C && v);
    }

    public final void F(String str) {
        if (this.p == null || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig.newInstance(this.f63112e.getPageActivity()).setType(9).setForumWriteData(this.p).setShowVoteData(this.o).setTitle(str).send();
    }

    public final void G(TextView textView, boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.f63112e.getResources().getDimension(R.dimen.tbds10));
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

    public final void H() {
        G(this.v, this.B == -1);
        G(this.w, this.B == 1);
        G(this.x, this.B == 7);
        G(this.y, this.B == 30);
    }

    public final void I() {
        G(this.s, this.A != 1);
        G(this.t, this.A == 1);
    }

    public final void J(boolean z) {
        this.z.setEnabled(z);
        if (z) {
            this.z.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
        } else {
            this.z.setTextColor(d.a.n0.e3.c.a(SkinManager.getColor(R.color.CAM_X0302), 0.5f));
        }
    }

    @Override // d.a.m0.t0.a
    public Intent getResultIntent() {
        return this.E;
    }

    @Override // d.a.m0.t0.a
    public boolean isOnViewCancel() {
        return true;
    }

    @Override // d.a.m0.t0.a
    public boolean isOnViewTop() {
        LinearLayout linearLayout = this.j;
        return linearLayout != null && this.f63115h != null && linearLayout.getTop() == 0 && this.f63115h.getFirstVisiblePosition() == 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.vote_type_single) {
            this.A = 0;
            I();
        } else if (view.getId() == R.id.vote_type_multiple) {
            this.A = 1;
            I();
        } else if (view.getId() == R.id.vote_time_forever) {
            this.B = -1;
            H();
        } else if (view.getId() == R.id.vote_time_1_day) {
            this.B = 1;
            H();
        } else if (view.getId() == R.id.vote_time_7_days) {
            this.B = 7;
            H();
        } else if (view.getId() == R.id.vote_time_30_days) {
            this.B = 30;
            H();
        }
    }

    @Override // d.a.m0.t0.a
    public void onViewChangeSkinType(int i2) {
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0109);
        this.m.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
        this.m.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.r.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.u.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        if (this.C && this.D) {
            this.z.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
        } else {
            this.z.setTextColor(d.a.n0.e3.c.a(SkinManager.getColor(R.color.CAM_X0302), 0.5f));
        }
        I();
        H();
        WriteVoteViewAdapter writeVoteViewAdapter = this.f63116i;
        if (writeVoteViewAdapter != null) {
            writeVoteViewAdapter.notifyDataSetChanged();
        }
    }

    public final List<WriteVoteItemData> u() {
        ArrayList arrayList = new ArrayList();
        List<WriteVoteItemData> list = this.n;
        if (list == null) {
            return arrayList;
        }
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            WriteVoteItemData writeVoteItemData = new WriteVoteItemData();
            int i3 = i2 + 1;
            writeVoteItemData.setId(i3);
            writeVoteItemData.setText(this.n.get(i2).getText());
            arrayList.add(writeVoteItemData);
            i2 = i3;
        }
        return arrayList;
    }

    public final boolean v() {
        int size = this.n.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (StringUtils.isNull(this.n.get(i2).getText())) {
                return false;
            }
        }
        return true;
    }

    public final void w() {
        BdRecyclerView bdRecyclerView = new BdRecyclerView(this.f63112e.getPageActivity());
        this.f63115h = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(this.f63112e.getPageActivity()));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = l.g(this.f63112e.getPageActivity(), R.dimen.tbds27);
        this.f63113f.addView(this.f63115h, layoutParams);
        WriteVoteViewAdapter writeVoteViewAdapter = new WriteVoteViewAdapter(this.f63112e);
        this.f63116i = writeVoteViewAdapter;
        this.f63115h.setAdapter(writeVoteViewAdapter);
        A();
        y();
        x();
        z();
        this.f63115h.s(this.j);
        this.f63115h.r(this.k);
        this.f63116i.setData(this.n);
        B();
        this.m.requestFocus();
        this.m.postDelayed(new a(), 150L);
    }

    public final void x() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f63112e.getPageActivity()).inflate(R.layout.view_vote_footer, (ViewGroup) null);
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

    public final void y() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f63112e.getPageActivity()).inflate(R.layout.view_vote_header, (ViewGroup) null);
        this.j = linearLayout;
        this.l = (TextView) linearLayout.findViewById(R.id.vote_item_tip);
        this.m = (EditText) this.j.findViewById(R.id.vote_title);
    }

    public final void z() {
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.m.addTextChangedListener(new C1729b());
        this.f63116i.g(new c());
        this.f63115h.addOnScrollListener(new d());
        this.z.setOnClickListener(new e());
    }
}
