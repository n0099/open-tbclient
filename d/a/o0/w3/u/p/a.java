package d.a.o0.w3.u.p;

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
import d.a.n0.r.s.a;
import java.util.ArrayList;
import java.util.Calendar;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<WriteActivity> f66946a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f66947b;

    /* renamed from: c  reason: collision with root package name */
    public VoteView f66948c;

    /* renamed from: d  reason: collision with root package name */
    public WriteVoteData f66949d;

    /* renamed from: d.a.o0.w3.u.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1788a implements View.OnClickListener {

        /* renamed from: d.a.o0.w3.u.p.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1789a implements a.e {
            public C1789a() {
            }

            @Override // d.a.n0.r.s.a.e
            public void onClick(d.a.n0.r.s.a aVar) {
                a.this.f66949d = null;
                a.this.h(false);
                aVar.dismiss();
            }
        }

        /* renamed from: d.a.o0.w3.u.p.a$a$b */
        /* loaded from: classes5.dex */
        public class b implements a.e {
            public b(View$OnClickListenerC1788a view$OnClickListenerC1788a) {
            }

            @Override // d.a.n0.r.s.a.e
            public void onClick(d.a.n0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        public View$OnClickListenerC1788a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(a.this.f66946a.getPageActivity());
            aVar.setTitle(a.this.f66946a.getString(R.string.vote_delete_dialog_title));
            aVar.setTitleShowCenter(true);
            aVar.setMessage(a.this.f66946a.getString(R.string.vote_delete_dialog_message));
            aVar.setMessageShowCenter(true);
            aVar.setPositiveButton(R.string.delete, new C1789a());
            aVar.setNegativeButton(R.string.cancel, new b(this));
            aVar.create(a.this.f66946a).show();
        }
    }

    public a(TbPageContext<WriteActivity> tbPageContext, RelativeLayout relativeLayout) {
        this.f66946a = tbPageContext;
        this.f66947b = relativeLayout;
        VoteView voteView = new VoteView(this.f66946a.getPageActivity());
        this.f66948c = voteView;
        voteView.setPageContext(this.f66946a);
        this.f66948c.setDeleteOnClickListener(new View$OnClickListenerC1788a());
        this.f66948c.setVoteViewDeleteVisibility(0);
        this.f66947b.addView(this.f66948c);
        h(false);
    }

    public WriteVoteData c() {
        return this.f66949d;
    }

    public void d(int i2) {
        this.f66948c.C(i2);
    }

    public void e(View.OnClickListener onClickListener) {
        VoteView voteView = this.f66948c;
        if (voteView == null || onClickListener == null) {
            return;
        }
        voteView.setOnItemClickListener(onClickListener);
    }

    public void f(View.OnClickListener onClickListener) {
        VoteView voteView = this.f66948c;
        if (voteView == null || onClickListener == null) {
            return;
        }
        voteView.setOnClickListener(onClickListener);
    }

    public void g(WriteVoteData writeVoteData) {
        VoteView voteView;
        TbPageContext<WriteActivity> tbPageContext;
        int i2;
        String str;
        if (writeVoteData == null || (voteView = this.f66948c) == null) {
            return;
        }
        this.f66949d = writeVoteData;
        voteView.setVoteTitle(writeVoteData.getTitle());
        if (this.f66949d.getIs_multi() == 1) {
            tbPageContext = this.f66946a;
            i2 = R.string.vote_type_multiple;
        } else {
            tbPageContext = this.f66946a;
            i2 = R.string.vote_type_single;
        }
        String string = tbPageContext.getString(i2);
        int expire_type = this.f66949d.getExpire_type();
        if (expire_type > 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(6, expire_type);
            str = String.format(this.f66946a.getString(R.string.write_vote_content_time), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
        } else {
            str = "";
        }
        if (StringUtils.isNull(str)) {
            this.f66948c.setVoteSubContent(string);
        } else {
            VoteView voteView2 = this.f66948c;
            voteView2.setVoteSubContent(string + " · " + str);
        }
        ArrayList arrayList = new ArrayList();
        for (WriteVoteItemData writeVoteItemData : this.f66949d.getOptions()) {
            PollOptionData pollOptionData = new PollOptionData();
            pollOptionData.setId(writeVoteItemData.getId());
            pollOptionData.setText(writeVoteItemData.getText());
            arrayList.add(pollOptionData);
        }
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        if (arrayList.size() > 3) {
            this.f66948c.setData(arrayList.subList(0, 3));
        } else {
            this.f66948c.setData(arrayList);
        }
    }

    public void h(boolean z) {
        this.f66947b.setVisibility(z ? 0 : 8);
    }
}
