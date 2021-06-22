package d.a.n0.w.r;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.n0.w.n;
/* loaded from: classes3.dex */
public class c {

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f54650e;

        public a(n nVar) {
            this.f54650e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            n nVar = this.f54650e;
            if (nVar != null) {
                nVar.d(new d.a.n0.w.a(14, -1, Boolean.TRUE));
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public static n a(Context context, int i2) {
        d.a.n0.b0.b bVar = new d.a.n0.b0.b();
        MultiImgToolView multiImgToolView = (MultiImgToolView) LayoutInflater.from(context).inflate(R.layout.editor_tool_container_image, (ViewGroup) null);
        multiImgToolView.p();
        if (multiImgToolView == null || multiImgToolView.getDragLayer() == null || multiImgToolView.getDragHorizonScrollView() == null || multiImgToolView.getMutiImageTips() == null) {
            return null;
        }
        multiImgToolView.setAsyncLocalImageLoader(bVar);
        d.a.o0.e3.k0.a aVar = new d.a.o0.e3.k0.a(context);
        aVar.e(multiImgToolView.getDragLayer());
        aVar.g(multiImgToolView.getDragHorizonScrollView());
        aVar.f(multiImgToolView.getDragHorizonScrollView());
        if (i2 > 1) {
            multiImgToolView.getDragHorizonScrollView().setAddView(b(context, multiImgToolView));
        } else {
            multiImgToolView.getDragHorizonScrollView().setCenterStart(true);
        }
        multiImgToolView.getDragHorizonScrollView().setOnSwapDataListener(multiImgToolView);
        multiImgToolView.getDragHorizonScrollView().setMaxItemNum(i2);
        SkinManager.setViewTextColor(multiImgToolView.getMutiImageTips(), R.color.CAM_X0108, 1);
        return multiImgToolView;
    }

    public static View b(Context context, n nVar) {
        ImageView imageView = new ImageView(context);
        SkinManager.setImageResource(imageView, R.drawable.btn_add_photo_selector);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setClickable(true);
        imageView.setContentDescription(context.getString(R.string.add));
        int e2 = l.e(context, 3.0f);
        imageView.setPadding(e2, context.getResources().getDimensionPixelSize(R.dimen.ds30) + e2 + l.e(context, 1.0f), context.getResources().getDimensionPixelSize(R.dimen.ds32) + e2, e2);
        imageView.setOnClickListener(new a(nVar));
        return imageView;
    }
}
