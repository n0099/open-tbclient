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
    public View f59999a;

    /* renamed from: b  reason: collision with root package name */
    public Context f60000b;

    /* renamed from: c  reason: collision with root package name */
    public View f60001c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f60002d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f60003e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f60004f;

    /* renamed from: g  reason: collision with root package name */
    public PostWriteCallBackData f60005g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60006h;

    /* renamed from: i  reason: collision with root package name */
    public SendVideoSuccessShareModel f60007i = new SendVideoSuccessShareModel();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f60004f) {
                e.this.f();
                if (e.this.f60005g == null || StringUtils.isNull(e.this.f60005g.buildVideoFakeOnWallUrl())) {
                    return;
                }
                d.a.m0.l.a.m(e.this.f60000b, null, e.this.f60005g.buildVideoFakeOnWallUrl());
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
                d.a.n0.d0.f.b().k(new ShareDialogConfig(e.this.f60000b, shareItem, true, true));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.OBJ_PARAM2, 1).param(TiebaStatic.Params.OBJ_PARAM3, 1));
            }
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.f();
            if (e.this.f60005g == null || StringUtils.isNull(e.this.f60005g.getVideoid())) {
                return;
            }
            e.this.f60007i.u(e.this.f60005g.getVideoid());
            e.this.f60007i.setLoadDataCallBack(new a());
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
        this.f60000b = context;
        this.f60001c = viewGroup;
        if (this.f60000b == null || this.f60001c == null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
        this.f59999a = inflate;
        this.f60002d = (TextView) inflate.findViewById(R.id.success_tip);
        this.f60003e = (ImageView) this.f59999a.findViewById(R.id.video_activity_btn);
        this.f60006h = (TextView) this.f59999a.findViewById(R.id.video_share_btn);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.g(context, R.dimen.ds128));
        if (this.f59999a.getParent() == null) {
            viewGroup.addView(this.f59999a, layoutParams);
        }
        this.f59999a.setVisibility(8);
        this.f59999a.setOnClickListener(new a());
        this.f60006h.setOnClickListener(new b());
    }

    public void e() {
        SendVideoSuccessShareModel sendVideoSuccessShareModel = this.f60007i;
        if (sendVideoSuccessShareModel != null) {
            sendVideoSuccessShareModel.cancelLoadData();
        }
    }

    public void f() {
        View view = this.f59999a;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.f60005g = postWriteCallBackData;
            this.f60004f = postWriteCallBackData.mVideoTitleData != null;
            View view = this.f59999a;
            if (view == null || this.f60002d == null || this.f60003e == null || this.f60006h == null) {
                return;
            }
            SkinManager.setBackgroundColor(view, R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.f60002d, R.color.CAM_X0101);
            SkinManager.setImageResource(this.f60003e, R.drawable.icon_arrow_more_white);
            SkinManager.setBackgroundResource(this.f60006h, R.drawable.immediately_share_background);
            this.f59999a.setVisibility(0);
            this.f59999a.postDelayed(new c(), 5000L);
            if (this.f60004f) {
                this.f60002d.setText(R.string.video_activity_tip);
            } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                this.f60002d.setText(postWriteCallBackData.getErrorString());
            } else {
                this.f59999a.setVisibility(8);
            }
        }
    }
}
