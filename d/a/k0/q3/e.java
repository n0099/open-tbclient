package d.a.k0.q3;

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
    public View f59858a;

    /* renamed from: b  reason: collision with root package name */
    public Context f59859b;

    /* renamed from: c  reason: collision with root package name */
    public View f59860c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59861d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f59862e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59863f;

    /* renamed from: g  reason: collision with root package name */
    public PostWriteCallBackData f59864g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f59865h;

    /* renamed from: i  reason: collision with root package name */
    public SendVideoSuccessShareModel f59866i = new SendVideoSuccessShareModel();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f59863f) {
                e.this.f();
                if (e.this.f59864g == null || StringUtils.isNull(e.this.f59864g.buildVideoFakeOnWallUrl())) {
                    return;
                }
                d.a.j0.l.a.m(e.this.f59859b, null, e.this.f59864g.buildVideoFakeOnWallUrl());
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
                d.a.k0.b0.f.b().k(new ShareDialogConfig(e.this.f59859b, shareItem, true, true));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.OBJ_PARAM2, 1).param(TiebaStatic.Params.OBJ_PARAM3, 1));
            }
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.f();
            if (e.this.f59864g == null || StringUtils.isNull(e.this.f59864g.getVideoid())) {
                return;
            }
            e.this.f59866i.u(e.this.f59864g.getVideoid());
            e.this.f59866i.setLoadDataCallBack(new a());
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
        this.f59859b = context;
        this.f59860c = viewGroup;
        if (this.f59859b == null || this.f59860c == null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
        this.f59858a = inflate;
        this.f59861d = (TextView) inflate.findViewById(R.id.success_tip);
        this.f59862e = (ImageView) this.f59858a.findViewById(R.id.video_activity_btn);
        this.f59865h = (TextView) this.f59858a.findViewById(R.id.video_share_btn);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.g(context, R.dimen.ds128));
        if (this.f59858a.getParent() == null) {
            viewGroup.addView(this.f59858a, layoutParams);
        }
        this.f59858a.setVisibility(8);
        this.f59858a.setOnClickListener(new a());
        this.f59865h.setOnClickListener(new b());
    }

    public void e() {
        SendVideoSuccessShareModel sendVideoSuccessShareModel = this.f59866i;
        if (sendVideoSuccessShareModel != null) {
            sendVideoSuccessShareModel.cancelLoadData();
        }
    }

    public void f() {
        View view = this.f59858a;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.f59864g = postWriteCallBackData;
            this.f59863f = postWriteCallBackData.mVideoTitleData != null;
            View view = this.f59858a;
            if (view == null || this.f59861d == null || this.f59862e == null || this.f59865h == null) {
                return;
            }
            SkinManager.setBackgroundColor(view, R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.f59861d, R.color.CAM_X0101);
            SkinManager.setImageResource(this.f59862e, R.drawable.icon_arrow_more_white);
            SkinManager.setBackgroundResource(this.f59865h, R.drawable.immediately_share_background);
            this.f59858a.setVisibility(0);
            this.f59858a.postDelayed(new c(), 5000L);
            if (this.f59863f) {
                this.f59861d.setText(R.string.video_activity_tip);
            } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                this.f59861d.setText(postWriteCallBackData.getErrorString());
            } else {
                this.f59858a.setVisibility(8);
            }
        }
    }
}
