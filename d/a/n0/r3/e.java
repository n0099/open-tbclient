package d.a.n0.r3;

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
    public View f63690a;

    /* renamed from: b  reason: collision with root package name */
    public Context f63691b;

    /* renamed from: c  reason: collision with root package name */
    public View f63692c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f63693d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f63694e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63695f;

    /* renamed from: g  reason: collision with root package name */
    public PostWriteCallBackData f63696g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f63697h;

    /* renamed from: i  reason: collision with root package name */
    public SendVideoSuccessShareModel f63698i = new SendVideoSuccessShareModel();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f63695f) {
                e.this.f();
                if (e.this.f63696g == null || StringUtils.isNull(e.this.f63696g.buildVideoFakeOnWallUrl())) {
                    return;
                }
                d.a.m0.l.a.m(e.this.f63691b, null, e.this.f63696g.buildVideoFakeOnWallUrl());
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
                d.a.n0.d0.f.b().k(new ShareDialogConfig(e.this.f63691b, shareItem, true, true));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.OBJ_PARAM2, 1).param(TiebaStatic.Params.OBJ_PARAM3, 1));
            }
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.f();
            if (e.this.f63696g == null || StringUtils.isNull(e.this.f63696g.getVideoid())) {
                return;
            }
            e.this.f63698i.y(e.this.f63696g.getVideoid());
            e.this.f63698i.setLoadDataCallBack(new a());
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
        this.f63691b = context;
        this.f63692c = viewGroup;
        if (this.f63691b == null || this.f63692c == null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
        this.f63690a = inflate;
        this.f63693d = (TextView) inflate.findViewById(R.id.success_tip);
        this.f63694e = (ImageView) this.f63690a.findViewById(R.id.video_activity_btn);
        this.f63697h = (TextView) this.f63690a.findViewById(R.id.video_share_btn);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.g(context, R.dimen.ds128));
        if (this.f63690a.getParent() == null) {
            viewGroup.addView(this.f63690a, layoutParams);
        }
        this.f63690a.setVisibility(8);
        this.f63690a.setOnClickListener(new a());
        this.f63697h.setOnClickListener(new b());
    }

    public void e() {
        SendVideoSuccessShareModel sendVideoSuccessShareModel = this.f63698i;
        if (sendVideoSuccessShareModel != null) {
            sendVideoSuccessShareModel.cancelLoadData();
        }
    }

    public void f() {
        View view = this.f63690a;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.f63696g = postWriteCallBackData;
            this.f63695f = postWriteCallBackData.mVideoTitleData != null;
            View view = this.f63690a;
            if (view == null || this.f63693d == null || this.f63694e == null || this.f63697h == null) {
                return;
            }
            SkinManager.setBackgroundColor(view, R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.f63693d, R.color.CAM_X0101);
            SkinManager.setImageResource(this.f63694e, R.drawable.icon_arrow_more_white);
            SkinManager.setBackgroundResource(this.f63697h, R.drawable.immediately_share_background);
            this.f63690a.setVisibility(0);
            this.f63690a.postDelayed(new c(), 5000L);
            if (this.f63695f) {
                this.f63693d.setText(R.string.video_activity_tip);
            } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                this.f63693d.setText(postWriteCallBackData.getErrorString());
            } else {
                this.f63690a.setVisibility(8);
            }
        }
    }
}
