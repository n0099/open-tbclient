package d.a.o0.r3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.SendVideoSuccessShareModel;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public View f63815a;

    /* renamed from: b  reason: collision with root package name */
    public Context f63816b;

    /* renamed from: c  reason: collision with root package name */
    public View f63817c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f63818d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f63819e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63820f;

    /* renamed from: g  reason: collision with root package name */
    public PostWriteCallBackData f63821g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f63822h;

    /* renamed from: i  reason: collision with root package name */
    public SendVideoSuccessShareModel f63823i = new SendVideoSuccessShareModel();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f63820f) {
                e.this.f();
                if (e.this.f63821g == null || StringUtils.isNull(e.this.f63821g.buildVideoFakeOnWallUrl())) {
                    return;
                }
                d.a.n0.l.a.m(e.this.f63816b, null, e.this.f63821g.buildVideoFakeOnWallUrl());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* loaded from: classes5.dex */
        public class a extends d.a.c.a.e {
            public a() {
            }

            @Override // d.a.c.a.e
            public void c(Object obj) {
                ShareItem shareItem = new ShareItem();
                shareItem.a0 = false;
                shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                d.a.o0.d0.f.b().k(new ShareDialogConfig(e.this.f63816b, shareItem, true, true));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.OBJ_PARAM2, 1).param(TiebaStatic.Params.OBJ_PARAM3, 1));
            }
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.f();
            if (e.this.f63821g == null || StringUtils.isNull(e.this.f63821g.getVideoid())) {
                return;
            }
            e.this.f63823i.y(e.this.f63821g.getVideoid());
            e.this.f63823i.setLoadDataCallBack(new a());
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f();
        }
    }

    public e(Context context, ViewGroup viewGroup) {
        this.f63816b = context;
        this.f63817c = viewGroup;
        if (this.f63816b == null || this.f63817c == null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
        this.f63815a = inflate;
        this.f63818d = (TextView) inflate.findViewById(R.id.success_tip);
        this.f63819e = (ImageView) this.f63815a.findViewById(R.id.video_activity_btn);
        this.f63822h = (TextView) this.f63815a.findViewById(R.id.video_share_btn);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.g(context, R.dimen.ds128));
        if (this.f63815a.getParent() == null) {
            viewGroup.addView(this.f63815a, layoutParams);
        }
        this.f63815a.setVisibility(8);
        this.f63815a.setOnClickListener(new a());
        this.f63822h.setOnClickListener(new b());
    }

    public void e() {
        SendVideoSuccessShareModel sendVideoSuccessShareModel = this.f63823i;
        if (sendVideoSuccessShareModel != null) {
            sendVideoSuccessShareModel.cancelLoadData();
        }
    }

    public void f() {
        View view = this.f63815a;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.f63821g = postWriteCallBackData;
            this.f63820f = postWriteCallBackData.mVideoTitleData != null;
            View view = this.f63815a;
            if (view == null || this.f63818d == null || this.f63819e == null || this.f63822h == null) {
                return;
            }
            SkinManager.setBackgroundColor(view, R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.f63818d, R.color.CAM_X0101);
            SkinManager.setImageResource(this.f63819e, R.drawable.icon_arrow_more_white);
            SkinManager.setBackgroundResource(this.f63822h, R.drawable.immediately_share_background);
            this.f63815a.setVisibility(0);
            this.f63815a.postDelayed(new c(), 5000L);
            if (this.f63820f) {
                this.f63818d.setText(R.string.video_activity_tip);
            } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                this.f63818d.setText(postWriteCallBackData.getErrorString());
            } else {
                this.f63815a.setVisibility(8);
            }
        }
    }
}
