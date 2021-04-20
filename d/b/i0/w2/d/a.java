package d.b.i0.w2.d;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import d.b.c.a.i;
import d.b.c.a.j;
import d.b.c.e.p.l;
import d.b.h0.f0.h;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
/* loaded from: classes4.dex */
public abstract class a implements d.b.i0.w2.e.a {

    /* renamed from: e  reason: collision with root package name */
    public static String f63714e = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/share";

    /* renamed from: f  reason: collision with root package name */
    public static String f63715f = "temp_video_thumb.png";

    /* renamed from: g  reason: collision with root package name */
    public static String f63716g = "_temp_share_pic.png";

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f63717a;

    /* renamed from: b  reason: collision with root package name */
    public Context f63718b;

    /* renamed from: c  reason: collision with root package name */
    public String f63719c;

    /* renamed from: d  reason: collision with root package name */
    public String f63720d;

    public a(Context context) {
        this.f63718b = context;
    }

    public void b(int i, int i2) {
        ShareEvent shareEvent = new ShareEvent();
        shareEvent.status = i;
        shareEvent.tid = this.f63719c;
        shareEvent.channel = i2;
        shareEvent.extLiveInfo = this.f63720d;
        h.i(shareEvent);
    }

    public Context c() {
        return TbadkCoreApplication.getInst().getContext();
    }

    public Bitmap d() {
        return BitmapHelper.getCashBitmap(R.drawable.tb_launcher_icon);
    }

    public Bitmap e(int i) {
        return BitmapHelper.getCashBitmap(i);
    }

    public Bitmap f(Uri uri) {
        return BitmapHelper.loadBitmap(uri.getPath());
    }

    public Bitmap g(String str) {
        return BitmapHelper.loadBitmap(str);
    }

    public BdUniqueId h() {
        i c2;
        BdUniqueId bdUniqueId = this.f63717a;
        return (bdUniqueId == null && (c2 = j.c(this.f63718b)) != null) ? c2.getUniqueId() : bdUniqueId;
    }

    public Bitmap i(Bitmap bitmap, int i) {
        return BitmapHelper.resizeBitmap(bitmap, i, i, false);
    }

    public Bitmap j(Bitmap bitmap, int i, int i2) {
        return BitmapHelper.resizeBitmap(bitmap, i, i2, false);
    }

    public String k(int i, Object... objArr) {
        return c().getString(i, objArr);
    }

    public void l(Intent intent) {
    }

    public boolean m(Uri uri) {
        File file;
        if (uri == null) {
            return false;
        }
        try {
            file = new File(new URI(uri.toString()));
        } catch (IllegalArgumentException | URISyntaxException unused) {
        }
        return file.isFile() && file.exists();
    }

    public boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.isFile() && file.exists();
    }

    public d.b.c.j.d.a o(ShareEntity shareEntity) {
        Bundle bundle;
        if (shareEntity == null || (bundle = shareEntity.diskPicOperate) == null) {
            return null;
        }
        String string = bundle.getString("path");
        String string2 = bundle.getString("name");
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            return null;
        }
        boolean z = bundle.getBoolean("isSubDir", true);
        boolean z2 = bundle.getBoolean("isSdcard", false);
        boolean z3 = bundle.getBoolean("isSavedCache", true);
        boolean z4 = bundle.getBoolean("formatData", true);
        d.b.c.e.a.f.c cVar = new d.b.c.e.a.f.c(string, string2, DiskFileOperate.Action.READ);
        cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        cVar.setSubFolder(z);
        cVar.setIsFormatData(z4);
        cVar.setSdCard(z2);
        cVar.setSavedCache(z3);
        if (d.b.c.e.a.d.g().d(cVar) && cVar.isSuccess()) {
            cVar.formatData(cVar.getData());
            Bitmap bitmap = cVar.getBitmap();
            if (bitmap != null) {
                return new d.b.c.j.d.a(bitmap, cVar.isGif());
            }
            return null;
        }
        return null;
    }

    public void p() {
    }

    public void q(BdUniqueId bdUniqueId) {
        this.f63717a = bdUniqueId;
    }

    public Bitmap r(Bitmap bitmap, ShareEntity shareEntity, boolean z) {
        if (bitmap == null) {
            return null;
        }
        Bitmap i = i(bitmap, (l.g(this.f63718b, R.dimen.tbds113) * Math.max(bitmap.getWidth(), bitmap.getHeight())) / Math.min(bitmap.getWidth(), bitmap.getHeight()));
        Bitmap createBitmap = Bitmap.createBitmap(i.getWidth(), i.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(i, 0.0f, 0.0f, (Paint) null);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, i.getHeight(), this.f63718b.getResources().getColor(R.color.CAM_X0601), this.f63718b.getResources().getColor(R.color.CAM_X0605), Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setShader(linearGradient);
        canvas.drawRect(0.0f, 0.0f, i.getWidth(), i.getHeight(), paint);
        Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_share_play_20, R.color.CAM_X0101, null, false);
        if (pureDrawable != null) {
            int min = (int) (Math.min(i.getWidth(), i.getHeight()) * 0.3f);
            int width = (i.getWidth() - min) / 2;
            int height = (i.getHeight() - min) / 2;
            pureDrawable.setBounds(width, height, width + min, min + height);
            pureDrawable.draw(canvas);
        }
        if (z) {
            String saveFileAsPNG = FileHelper.saveFileAsPNG(f63714e, f63715f, createBitmap, 100);
            if (!StringUtils.isNull(saveFileAsPNG)) {
                shareEntity.u(Uri.parse(saveFileAsPNG));
            }
        }
        return createBitmap;
    }

    public void s(String str) {
        this.f63720d = str;
    }

    public void t(String str) {
        this.f63719c = str;
    }

    public void u(String str) {
        y(str, R.drawable.icon_toast_game_error);
    }

    public void v(String str) {
        y(str, R.drawable.icon_toast_game_ok);
    }

    public void w(int i, int i2) {
        x(i, null, i2);
    }

    public void x(int i, String str, int i2) {
        if (i == 1) {
            if (TextUtils.isEmpty(str)) {
                str = k(R.string.share_success, new Object[0]);
            }
            v(str);
        } else if (i == 3) {
            if (TextUtils.isEmpty(str)) {
                str = k(R.string.share_cancel, new Object[0]);
            }
            u(str);
        } else if (i == 2) {
            if (TextUtils.isEmpty(str)) {
                str = k(R.string.share_failed, new Object[0]);
            }
            u(str);
        }
        if (!TextUtils.isEmpty(this.f63719c)) {
            b(i, i2);
        } else if (StringUtils.isNull(this.f63720d)) {
        } else {
            b(i, i2);
        }
    }

    public void y(String str, int i) {
        BdToast.i(c(), str, i, false).q();
    }
}
