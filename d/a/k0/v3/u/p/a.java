package d.a.k0.v3.u.p;

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
import d.a.j0.r.s.a;
import java.util.ArrayList;
import java.util.Calendar;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<WriteActivity> f62997a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f62998b;

    /* renamed from: c  reason: collision with root package name */
    public VoteView f62999c;

    /* renamed from: d  reason: collision with root package name */
    public WriteVoteData f63000d;

    /* renamed from: d.a.k0.v3.u.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1713a implements View.OnClickListener {

        /* renamed from: d.a.k0.v3.u.p.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1714a implements a.e {
            public C1714a() {
            }

            @Override // d.a.j0.r.s.a.e
            public void onClick(d.a.j0.r.s.a aVar) {
                a.this.f63000d = null;
                a.this.h(false);
                aVar.dismiss();
            }
        }

        /* renamed from: d.a.k0.v3.u.p.a$a$b */
        /* loaded from: classes5.dex */
        public class b implements a.e {
            public b(View$OnClickListenerC1713a view$OnClickListenerC1713a) {
            }

            @Override // d.a.j0.r.s.a.e
            public void onClick(d.a.j0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        public View$OnClickListenerC1713a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(a.this.f62997a.getPageActivity());
            aVar.setTitle(a.this.f62997a.getString(R.string.vote_delete_dialog_title));
            aVar.setTitleShowCenter(true);
            aVar.setMessage(a.this.f62997a.getString(R.string.vote_delete_dialog_message));
            aVar.setMessageShowCenter(true);
            aVar.setPositiveButton(R.string.delete, new C1714a());
            aVar.setNegativeButton(R.string.cancel, new b(this));
            aVar.create(a.this.f62997a).show();
        }
    }

    public a(TbPageContext<WriteActivity> tbPageContext, RelativeLayout relativeLayout) {
        this.f62997a = tbPageContext;
        this.f62998b = relativeLayout;
        VoteView voteView = new VoteView(this.f62997a.getPageActivity());
        this.f62999c = voteView;
        voteView.setPageContext(this.f62997a);
        this.f62999c.setDeleteOnClickListener(new View$OnClickListenerC1713a());
        this.f62999c.setVoteViewDeleteVisibility(0);
        this.f62998b.addView(this.f62999c);
        h(false);
    }

    public WriteVoteData c() {
        return this.f63000d;
    }

    public void d(int i2) {
        this.f62999c.C(i2);
    }

    public void e(View.OnClickListener onClickListener) {
        VoteView voteView = this.f62999c;
        if (voteView == null || onClickListener == null) {
            return;
        }
        voteView.setOnItemClickListener(onClickListener);
    }

    public void f(View.OnClickListener onClickListener) {
        VoteView voteView = this.f62999c;
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
        if (writeVoteData == null || (voteView = this.f62999c) == null) {
            return;
        }
        this.f63000d = writeVoteData;
        voteView.setVoteTitle(writeVoteData.getTitle());
        if (this.f63000d.getIs_multi() == 1) {
            tbPageContext = this.f62997a;
            i2 = R.string.vote_type_multiple;
        } else {
            tbPageContext = this.f62997a;
            i2 = R.string.vote_type_single;
        }
        String string = tbPageContext.getString(i2);
        int expire_type = this.f63000d.getExpire_type();
        if (expire_type > 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(6, expire_type);
            str = String.format(this.f62997a.getString(R.string.write_vote_content_time), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
        } else {
            str = "";
        }
        if (StringUtils.isNull(str)) {
            this.f62999c.setVoteSubContent(string);
        } else {
            VoteView voteView2 = this.f62999c;
            voteView2.setVoteSubContent(string + " · " + str);
        }
        ArrayList arrayList = new ArrayList();
        for (WriteVoteItemData writeVoteItemData : this.f63000d.getOptions()) {
            PollOptionData pollOptionData = new PollOptionData();
            pollOptionData.setId(writeVoteItemData.getId());
            pollOptionData.setText(writeVoteItemData.getText());
            arrayList.add(pollOptionData);
        }
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        if (arrayList.size() > 3) {
            this.f62999c.setData(arrayList.subList(0, 3));
        } else {
            this.f62999c.setData(arrayList);
        }
    }

    public void h(boolean z) {
        this.f62998b.setVisibility(z ? 0 : 8);
    }
}
