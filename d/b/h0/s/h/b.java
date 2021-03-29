package d.b.h0.s.h;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NewUserRewardDialogView;
/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewUserRewardDialogView f51378e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f51379f;

        public a(NewUserRewardDialogView newUserRewardDialogView, d.b.h0.r.s.a aVar) {
            this.f51378e = newUserRewardDialogView;
            this.f51379f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f51378e.d();
            this.f51379f.dismiss();
        }
    }

    public static void a(TbPageContext tbPageContext, PostWriteCallBackData postWriteCallBackData) {
        NewUserRewardDialogView newUserRewardDialogView = new NewUserRewardDialogView(tbPageContext.getPageActivity());
        newUserRewardDialogView.setData(postWriteCallBackData.getIconStampData());
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(tbPageContext.getPageActivity());
        aVar.setContentViewSize(5);
        aVar.setContentView(newUserRewardDialogView);
        aVar.setCanceledOnTouchOutside(false);
        aVar.setAnimRes(R.style.picker_view_scale_anim);
        aVar.create(tbPageContext).show();
        newUserRewardDialogView.setCloseListener(new a(newUserRewardDialogView, aVar));
    }
}
