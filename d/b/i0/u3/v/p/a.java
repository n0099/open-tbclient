package d.b.i0.u3.v.p;

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
import d.b.h0.r.s.a;
import java.util.ArrayList;
import java.util.Calendar;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<WriteActivity> f61864a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f61865b;

    /* renamed from: c  reason: collision with root package name */
    public VoteView f61866c;

    /* renamed from: d  reason: collision with root package name */
    public WriteVoteData f61867d;

    /* renamed from: d.b.i0.u3.v.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1627a implements View.OnClickListener {

        /* renamed from: d.b.i0.u3.v.p.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1628a implements a.e {
            public C1628a() {
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                a.this.f61867d = null;
                a.this.h(false);
                aVar.dismiss();
            }
        }

        /* renamed from: d.b.i0.u3.v.p.a$a$b */
        /* loaded from: classes5.dex */
        public class b implements a.e {
            public b(View$OnClickListenerC1627a view$OnClickListenerC1627a) {
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        public View$OnClickListenerC1627a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(a.this.f61864a.getPageActivity());
            aVar.setTitle(a.this.f61864a.getString(R.string.vote_delete_dialog_title));
            aVar.setTitleShowCenter(true);
            aVar.setMessage(a.this.f61864a.getString(R.string.vote_delete_dialog_message));
            aVar.setMessageShowCenter(true);
            aVar.setPositiveButton(R.string.delete, new C1628a());
            aVar.setNegativeButton(R.string.cancel, new b(this));
            aVar.create(a.this.f61864a).show();
        }
    }

    public a(TbPageContext<WriteActivity> tbPageContext, RelativeLayout relativeLayout) {
        this.f61864a = tbPageContext;
        this.f61865b = relativeLayout;
        VoteView voteView = new VoteView(this.f61864a.getPageActivity());
        this.f61866c = voteView;
        voteView.setPageContext(this.f61864a);
        this.f61866c.setDeleteOnClickListener(new View$OnClickListenerC1627a());
        this.f61866c.setVoteViewDeleteVisibility(0);
        this.f61865b.addView(this.f61866c);
        h(false);
    }

    public WriteVoteData c() {
        return this.f61867d;
    }

    public void d(int i) {
        this.f61866c.C(i);
    }

    public void e(View.OnClickListener onClickListener) {
        VoteView voteView = this.f61866c;
        if (voteView == null || onClickListener == null) {
            return;
        }
        voteView.setOnItemClickListener(onClickListener);
    }

    public void f(View.OnClickListener onClickListener) {
        VoteView voteView = this.f61866c;
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
        if (writeVoteData == null || (voteView = this.f61866c) == null) {
            return;
        }
        this.f61867d = writeVoteData;
        voteView.setVoteTitle(writeVoteData.getTitle());
        if (this.f61867d.getIs_multi() == 1) {
            tbPageContext = this.f61864a;
            i = R.string.vote_type_multiple;
        } else {
            tbPageContext = this.f61864a;
            i = R.string.vote_type_single;
        }
        String string = tbPageContext.getString(i);
        int expire_type = this.f61867d.getExpire_type();
        if (expire_type > 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(6, expire_type);
            str = String.format(this.f61864a.getString(R.string.write_vote_content_time), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
        } else {
            str = "";
        }
        if (StringUtils.isNull(str)) {
            this.f61866c.setVoteSubContent(string);
        } else {
            VoteView voteView2 = this.f61866c;
            voteView2.setVoteSubContent(string + " · " + str);
        }
        ArrayList arrayList = new ArrayList();
        for (WriteVoteItemData writeVoteItemData : this.f61867d.getOptions()) {
            PollOptionData pollOptionData = new PollOptionData();
            pollOptionData.setId(writeVoteItemData.getId());
            pollOptionData.setText(writeVoteItemData.getText());
            arrayList.add(pollOptionData);
        }
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        if (arrayList.size() > 3) {
            this.f61866c.setData(arrayList.subList(0, 3));
        } else {
            this.f61866c.setData(arrayList);
        }
    }

    public void h(boolean z) {
        this.f61865b.setVisibility(z ? 0 : 8);
    }
}
