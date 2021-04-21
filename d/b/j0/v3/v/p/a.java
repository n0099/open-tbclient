package d.b.j0.v3.v.p;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.PollOptionData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.WriteActivity;
import d.b.i0.r.s.a;
import java.util.ArrayList;
import java.util.Calendar;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<WriteActivity> f64024a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f64025b;

    /* renamed from: c  reason: collision with root package name */
    public VoteView f64026c;

    /* renamed from: d  reason: collision with root package name */
    public WriteVoteData f64027d;

    /* renamed from: d.b.j0.v3.v.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1711a implements View.OnClickListener {

        /* renamed from: d.b.j0.v3.v.p.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1712a implements a.e {
            public C1712a() {
            }

            @Override // d.b.i0.r.s.a.e
            public void onClick(d.b.i0.r.s.a aVar) {
                a.this.f64027d = null;
                a.this.h(false);
                aVar.dismiss();
            }
        }

        /* renamed from: d.b.j0.v3.v.p.a$a$b */
        /* loaded from: classes5.dex */
        public class b implements a.e {
            public b(View$OnClickListenerC1711a view$OnClickListenerC1711a) {
            }

            @Override // d.b.i0.r.s.a.e
            public void onClick(d.b.i0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        public View$OnClickListenerC1711a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(a.this.f64024a.getPageActivity());
            aVar.setTitle(a.this.f64024a.getString(R.string.vote_delete_dialog_title));
            aVar.setTitleShowCenter(true);
            aVar.setMessage(a.this.f64024a.getString(R.string.vote_delete_dialog_message));
            aVar.setMessageShowCenter(true);
            aVar.setPositiveButton(R.string.delete, new C1712a());
            aVar.setNegativeButton(R.string.cancel, new b(this));
            aVar.create(a.this.f64024a).show();
        }
    }

    public a(TbPageContext<WriteActivity> tbPageContext, RelativeLayout relativeLayout) {
        this.f64024a = tbPageContext;
        this.f64025b = relativeLayout;
        VoteView voteView = new VoteView(this.f64024a.getPageActivity());
        this.f64026c = voteView;
        voteView.setPageContext(this.f64024a);
        this.f64026c.setDeleteOnClickListener(new View$OnClickListenerC1711a());
        this.f64026c.setVoteViewDeleteVisibility(0);
        this.f64025b.addView(this.f64026c);
        h(false);
    }

    public WriteVoteData c() {
        return this.f64027d;
    }

    public void d(int i) {
        this.f64026c.C(i);
    }

    public void e(View.OnClickListener onClickListener) {
        VoteView voteView = this.f64026c;
        if (voteView == null || onClickListener == null) {
            return;
        }
        voteView.setOnItemClickListener(onClickListener);
    }

    public void f(View.OnClickListener onClickListener) {
        VoteView voteView = this.f64026c;
        if (voteView == null || onClickListener == null) {
            return;
        }
        voteView.setOnClickListener(onClickListener);
    }

    public void g(WriteVoteData writeVoteData) {
        VoteView voteView;
        TbPageContext<WriteActivity> tbPageContext;
        int i;
        String str;
        if (writeVoteData == null || (voteView = this.f64026c) == null) {
            return;
        }
        this.f64027d = writeVoteData;
        voteView.setVoteTitle(writeVoteData.getTitle());
        if (this.f64027d.getIs_multi() == 1) {
            tbPageContext = this.f64024a;
            i = R.string.vote_type_multiple;
        } else {
            tbPageContext = this.f64024a;
            i = R.string.vote_type_single;
        }
        String string = tbPageContext.getString(i);
        int expire_type = this.f64027d.getExpire_type();
        if (expire_type > 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(6, expire_type);
            str = String.format(this.f64024a.getString(R.string.write_vote_content_time), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
        } else {
            str = "";
        }
        if (StringUtils.isNull(str)) {
            this.f64026c.setVoteSubContent(string);
        } else {
            VoteView voteView2 = this.f64026c;
            voteView2.setVoteSubContent(string + " · " + str);
        }
        ArrayList arrayList = new ArrayList();
        for (WriteVoteItemData writeVoteItemData : this.f64027d.getOptions()) {
            PollOptionData pollOptionData = new PollOptionData();
            pollOptionData.setId(writeVoteItemData.getId());
            pollOptionData.setText(writeVoteItemData.getText());
            arrayList.add(pollOptionData);
        }
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        if (arrayList.size() > 3) {
            this.f64026c.setData(arrayList.subList(0, 3));
        } else {
            this.f64026c.setData(arrayList);
        }
    }

    public void h(boolean z) {
        this.f64025b.setVisibility(z ? 0 : 8);
    }
}
