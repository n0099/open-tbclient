package d.a.j0.q3;

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
    public View f59113a;

    /* renamed from: b  reason: collision with root package name */
    public Context f59114b;

    /* renamed from: c  reason: collision with root package name */
    public View f59115c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59116d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f59117e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59118f;

    /* renamed from: g  reason: collision with root package name */
    public PostWriteCallBackData f59119g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f59120h;

    /* renamed from: i  reason: collision with root package name */
    public SendVideoSuccessShareModel f59121i = new SendVideoSuccessShareModel();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f59118f) {
                e.this.f();
                if (e.this.f59119g == null || StringUtils.isNull(e.this.f59119g.buildVideoFakeOnWallUrl())) {
                    return;
                }
                d.a.i0.l.a.m(e.this.f59114b, null, e.this.f59119g.buildVideoFakeOnWallUrl());
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
                d.a.j0.b0.f.b().k(new ShareDialogConfig(e.this.f59114b, shareItem, true, true));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.OBJ_PARAM2, 1).param(TiebaStatic.Params.OBJ_PARAM3, 1));
            }
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.f();
            if (e.this.f59119g == null || StringUtils.isNull(e.this.f59119g.getVideoid())) {
                return;
            }
            e.this.f59121i.u(e.this.f59119g.getVideoid());
            e.this.f59121i.setLoadDataCallBack(new a());
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
        this.f59114b = context;
        this.f59115c = viewGroup;
        if (this.f59114b == null || this.f59115c == null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
        this.f59113a = inflate;
        this.f59116d = (TextView) inflate.findViewById(R.id.success_tip);
        this.f59117e = (ImageView) this.f59113a.findViewById(R.id.video_activity_btn);
        this.f59120h = (TextView) this.f59113a.findViewById(R.id.video_share_btn);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.g(context, R.dimen.ds128));
        if (this.f59113a.getParent() == null) {
            viewGroup.addView(this.f59113a, layoutParams);
        }
        this.f59113a.setVisibility(8);
        this.f59113a.setOnClickListener(new a());
        this.f59120h.setOnClickListener(new b());
    }

    public void e() {
        SendVideoSuccessShareModel sendVideoSuccessShareModel = this.f59121i;
        if (sendVideoSuccessShareModel != null) {
            sendVideoSuccessShareModel.cancelLoadData();
        }
    }

    public void f() {
        View view = this.f59113a;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.f59119g = postWriteCallBackData;
            this.f59118f = postWriteCallBackData.mVideoTitleData != null;
            View view = this.f59113a;
            if (view == null || this.f59116d == null || this.f59117e == null || this.f59120h == null) {
                return;
            }
            SkinManager.setBackgroundColor(view, R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.f59116d, R.color.CAM_X0101);
            SkinManager.setImageResource(this.f59117e, R.drawable.icon_arrow_more_white);
            SkinManager.setBackgroundResource(this.f59120h, R.drawable.immediately_share_background);
            this.f59113a.setVisibility(0);
            this.f59113a.postDelayed(new c(), 5000L);
            if (this.f59118f) {
                this.f59116d.setText(R.string.video_activity_tip);
            } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                this.f59116d.setText(postWriteCallBackData.getErrorString());
            } else {
                this.f59113a.setVisibility(8);
            }
        }
    }
}
