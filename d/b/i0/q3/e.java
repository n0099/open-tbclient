package d.b.i0.q3;

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
import d.b.c.e.p.l;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public View f60562a;

    /* renamed from: b  reason: collision with root package name */
    public Context f60563b;

    /* renamed from: c  reason: collision with root package name */
    public View f60564c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f60565d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f60566e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f60567f;

    /* renamed from: g  reason: collision with root package name */
    public PostWriteCallBackData f60568g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60569h;
    public SendVideoSuccessShareModel i = new SendVideoSuccessShareModel();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f60567f) {
                e.this.f();
                if (e.this.f60568g == null || StringUtils.isNull(e.this.f60568g.buildVideoFakeOnWallUrl())) {
                    return;
                }
                d.b.h0.l.a.m(e.this.f60563b, null, e.this.f60568g.buildVideoFakeOnWallUrl());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* loaded from: classes5.dex */
        public class a extends d.b.c.a.e {
            public a() {
            }

            @Override // d.b.c.a.e
            public void c(Object obj) {
                ShareItem shareItem = new ShareItem();
                shareItem.Y = false;
                shareItem.S = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                d.b.i0.b0.f.b().k(new ShareDialogConfig(e.this.f60563b, shareItem, true, true));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.OBJ_PARAM2, 1).param(TiebaStatic.Params.OBJ_PARAM3, 1));
            }
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.f();
            if (e.this.f60568g == null || StringUtils.isNull(e.this.f60568g.getVideoid())) {
                return;
            }
            e.this.i.u(e.this.f60568g.getVideoid());
            e.this.i.setLoadDataCallBack(new a());
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
        this.f60563b = context;
        this.f60564c = viewGroup;
        if (this.f60563b == null || this.f60564c == null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
        this.f60562a = inflate;
        this.f60565d = (TextView) inflate.findViewById(R.id.success_tip);
        this.f60566e = (ImageView) this.f60562a.findViewById(R.id.video_activity_btn);
        this.f60569h = (TextView) this.f60562a.findViewById(R.id.video_share_btn);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.g(context, R.dimen.ds128));
        if (this.f60562a.getParent() == null) {
            viewGroup.addView(this.f60562a, layoutParams);
        }
        this.f60562a.setVisibility(8);
        this.f60562a.setOnClickListener(new a());
        this.f60569h.setOnClickListener(new b());
    }

    public void e() {
        SendVideoSuccessShareModel sendVideoSuccessShareModel = this.i;
        if (sendVideoSuccessShareModel != null) {
            sendVideoSuccessShareModel.cancelLoadData();
        }
    }

    public void f() {
        View view = this.f60562a;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.f60568g = postWriteCallBackData;
            this.f60567f = postWriteCallBackData.mVideoTitleData != null;
            View view = this.f60562a;
            if (view == null || this.f60565d == null || this.f60566e == null || this.f60569h == null) {
                return;
            }
            SkinManager.setBackgroundColor(view, R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.f60565d, R.color.CAM_X0101);
            SkinManager.setImageResource(this.f60566e, R.drawable.icon_arrow_more_white);
            SkinManager.setBackgroundResource(this.f60569h, R.drawable.immediately_share_background);
            this.f60562a.setVisibility(0);
            this.f60562a.postDelayed(new c(), 5000L);
            if (this.f60567f) {
                this.f60565d.setText(R.string.video_activity_tip);
            } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                this.f60565d.setText(postWriteCallBackData.getErrorString());
            } else {
                this.f60562a.setVisibility(8);
            }
        }
    }
}
