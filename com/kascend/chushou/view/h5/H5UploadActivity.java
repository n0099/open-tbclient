package com.kascend.chushou.view.h5;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.baidu.android.util.media.MimeType;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kascend.chushou.a;
import com.kascend.chushou.bean.ImageInfo;
import com.kascend.chushou.d.i;
import com.kascend.chushou.view.base.BaseActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tv.chushou.basis.d.a.a.c;
import tv.chushou.zues.c;
import tv.chushou.zues.utils.e;
import tv.chushou.zues.utils.g;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.sweetalert.b;
/* loaded from: classes6.dex */
public class H5UploadActivity extends BaseActivity {
    private String b;
    private String c;
    private String d;
    private String e;
    private Uri nYm;
    private ProgressDialog nYl = null;
    private int f = 1;
    private String g = "";
    private String h = "upload";
    private ArrayList<ImageInfo> i = new ArrayList<>();
    private c nRU = new c(new Handler.Callback() { // from class: com.kascend.chushou.view.h5.H5UploadActivity.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (H5UploadActivity.this.nYl == null) {
                        H5UploadActivity.this.nYl = new ProgressDialog(H5UploadActivity.this.w);
                        H5UploadActivity.this.nYl.setProgressStyle(0);
                        H5UploadActivity.this.nYl.requestWindowFeature(1);
                        H5UploadActivity.this.nYl.setMessage(H5UploadActivity.this.w.getText(a.i.image_upload_progress));
                        H5UploadActivity.this.nYl.setCancelable(true);
                    }
                    if (!H5UploadActivity.this.nYl.isShowing()) {
                        H5UploadActivity.this.nYl.show();
                        break;
                    }
                    break;
                case 2:
                    if (H5UploadActivity.this.nYl != null && H5UploadActivity.this.nYl.isShowing()) {
                        H5UploadActivity.this.nYl.dismiss();
                    }
                    g.OF(a.i.image_upload_success);
                    H5UploadActivity.this.finish();
                    break;
                case 3:
                    if (H5UploadActivity.this.nYl != null && H5UploadActivity.this.nYl.isShowing()) {
                        H5UploadActivity.this.nYl.dismiss();
                    }
                    g.y((!(message.obj instanceof String) || h.isEmpty((String) message.obj)) ? H5UploadActivity.this.w.getResources().getString(a.i.image_upload_failure) : (String) message.obj);
                    break;
                case 4:
                    if (H5UploadActivity.this.nYl != null && H5UploadActivity.this.nYl.isShowing()) {
                        H5UploadActivity.this.nYl.dismiss();
                        H5UploadActivity.this.nYl = null;
                        break;
                    }
                    break;
            }
            return false;
        }
    });

    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String str = "";
        if (intent != null) {
            this.h = intent.getStringExtra("jsMethod");
            str = intent.getStringExtra("uploadParam");
        }
        if (h.isEmpty(this.h)) {
            this.h = "upload";
        }
        e.d(this.v, "param=" + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.c = jSONObject.optString("type");
            this.f = jSONObject.optInt("count", 1);
            this.d = jSONObject.optString("targetKey");
            this.e = jSONObject.optString("index");
            this.b = jSONObject.optString("path");
            this.g = jSONObject.optString(BuyTBeanActivityConfig.CALLBACK);
        } catch (Exception e) {
        }
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected void a() {
        setContentView(a.h.view_upload);
        findViewById(a.f.back_icon).setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.view.h5.H5UploadActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                H5UploadActivity.this.finish();
            }
        });
        ((TextView) findViewById(a.f.tittle_name)).setText(a.i.str_upload);
        findViewById(a.f.tv_btn).setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.view.h5.H5UploadActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                H5UploadActivity.this.c();
            }
        });
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    public void b() {
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.nYl != null && this.nYl.isShowing()) {
            this.nYl.dismiss();
        }
        super.onDestroy();
    }

    @Override // com.kascend.chushou.view.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        Intent intent = new Intent();
        intent.putExtra("jsMethod", this.h);
        intent.putExtra("uploadCallback", this.g);
        intent.putParcelableArrayListExtra("uploadResult", this.i);
        setResult(101, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 1001) {
                Uri uri = this.nYm;
                this.nYm = null;
                if (uri != null) {
                    a(i.a(this, uri));
                } else {
                    g.OF(a.i.get_photo_failured);
                }
            } else if (i == 1002) {
                Uri data = intent.getData();
                if (data != null) {
                    a(i.a(this, data));
                } else {
                    g.OF(a.i.get_photo_failured);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        final Dialog dialog = new Dialog(this.w, a.j.alert_dialog);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(a.e.powindow_circle_bg);
        }
        View inflate = LayoutInflater.from(this.w).inflate(a.h.dlg_choose_photo, (ViewGroup) null);
        inflate.findViewById(a.f.take_photo).setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.view.h5.H5UploadActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialog.dismiss();
                H5UploadActivity.this.e();
            }
        });
        inflate.findViewById(a.f.photo_album);
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.view.h5.H5UploadActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialog.dismiss();
                if (H5UploadActivity.this.i.size() != H5UploadActivity.this.f) {
                    H5UploadActivity.this.g();
                } else {
                    g.y(tv.chushou.widget.a.c.getString(a.i.str_upload_max_size, Integer.valueOf(H5UploadActivity.this.f)));
                }
            }
        });
        dialog.setContentView(inflate, new ViewGroup.LayoutParams((int) (tv.chushou.zues.utils.a.gW(this.w).x / 1.5d), this.w.getResources().getDimensionPixelSize(a.d.popwin_list_item_height) * 2));
        dialog.show();
    }

    private void a(final String str) {
        if (h.isEmpty(str)) {
            e.e(this.v, "uploadIconToQiNiu uri is null!");
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            g.OF(a.i.update_userinfo_failed);
            return;
        }
        tv.chushou.basis.d.a.a.c cVar = (tv.chushou.basis.d.a.a.c) tv.chushou.basis.d.b.elU().S(tv.chushou.basis.d.a.a.c.class);
        if (cVar == null) {
            g.OF(a.i.update_userinfo_failed);
        } else {
            cVar.b(this.c, this.b, file, new c.a() { // from class: com.kascend.chushou.view.h5.H5UploadActivity.13
                @Override // tv.chushou.basis.d.a.c.a
                public void onStart() {
                    if (!H5UploadActivity.this.isFinishing() && H5UploadActivity.this.nRU != null) {
                        H5UploadActivity.this.nRU.Ow(1);
                    }
                }

                @Override // tv.chushou.basis.d.a.a.c.a
                public void onProgress(int i) {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // tv.chushou.basis.d.a.c.a
                /* renamed from: a */
                public void onSuccess(String str2) {
                    if (!H5UploadActivity.this.isFinishing()) {
                        if ("upload".equals(H5UploadActivity.this.h)) {
                            H5UploadActivity.this.a(str, str2);
                            return;
                        }
                        ImageInfo decodeSync = ImageInfo.decodeSync(str);
                        decodeSync.url = str2;
                        H5UploadActivity.this.i.add(decodeSync);
                        if (H5UploadActivity.this.nRU != null) {
                            H5UploadActivity.this.nRU.Ow(2);
                        }
                    }
                }

                @Override // tv.chushou.basis.d.a.c.a
                public void onFailure(int i, String str2, Throwable th) {
                    if (!H5UploadActivity.this.isFinishing() && H5UploadActivity.this.nRU != null) {
                        H5UploadActivity.this.nRU.Ow(3);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final String str2) {
        com.kascend.chushou.c.c.dYv().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.view.h5.H5UploadActivity.2
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str3, JSONObject jSONObject) {
                if (!H5UploadActivity.this.isFinishing()) {
                    e.d(H5UploadActivity.this.v, "notifyUpdateSuccess success response=" + jSONObject);
                    int optInt = jSONObject.optInt("code", -1);
                    String optString = jSONObject.optString("message");
                    if (optInt != 0) {
                        if (H5UploadActivity.this.nRU != null) {
                            Message Oy = H5UploadActivity.this.nRU.Oy(3);
                            Oy.arg1 = optInt;
                            Oy.obj = optString;
                            H5UploadActivity.this.nRU.S(Oy);
                            return;
                        }
                        return;
                    }
                    ImageInfo decodeSync = ImageInfo.decodeSync(str);
                    decodeSync.url = str2;
                    H5UploadActivity.this.i.add(decodeSync);
                    if (H5UploadActivity.this.nRU != null) {
                        H5UploadActivity.this.nRU.Ow(2);
                    }
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str3) {
                if (!H5UploadActivity.this.isFinishing() && H5UploadActivity.this.nRU != null) {
                    H5UploadActivity.this.nRU.Ow(3);
                }
            }
        }, this.c, this.d, this.e, str2);
    }

    private Uri eaL() {
        return Uri.fromFile(new File(com.kascend.chushou.d.c.nHN.c(), "chushou_capture_" + System.currentTimeMillis() + ".jpg"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!new com.yanzhenjie.permission.a.b().e(this.w, PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
            com.yanzhenjie.permission.b.gL(this.w).W(PermissionRequest.RESOURCE_VIDEO_CAPTURE).a(new com.yanzhenjie.permission.g() { // from class: com.kascend.chushou.view.h5.H5UploadActivity.4
                @Override // com.yanzhenjie.permission.g
                public void showRationale(Context context, List<String> list, final com.yanzhenjie.permission.i iVar) {
                    List<String> c = com.yanzhenjie.permission.e.c(context, list);
                    final tv.chushou.zues.widget.sweetalert.b bVar = new tv.chushou.zues.widget.sweetalert.b(context);
                    bVar.a(new b.a() { // from class: com.kascend.chushou.view.h5.H5UploadActivity.4.2
                        @Override // tv.chushou.zues.widget.sweetalert.b.a
                        public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                            bVar.emV();
                            iVar.cancel();
                        }
                    }).b(new b.a() { // from class: com.kascend.chushou.view.h5.H5UploadActivity.4.1
                        @Override // tv.chushou.zues.widget.sweetalert.b.a
                        public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                            bVar.emV();
                            iVar.execute();
                        }
                    }).Xf(context.getString(a.i.alert_dialog_cancel)).Xh(context.getString(a.i.gallery_permissions_continue)).B(context.getString(a.i.gallery_permissions_rationale, c)).setCanceledOnTouchOutside(false);
                    bVar.show();
                }
            }).b(new com.yanzhenjie.permission.a() { // from class: com.kascend.chushou.view.h5.H5UploadActivity.6
                @Override // com.yanzhenjie.permission.a
                public void onAction(List<String> list) {
                    g.OF(a.i.gallery_camera_permission_denied);
                }
            }).a(new com.yanzhenjie.permission.a() { // from class: com.kascend.chushou.view.h5.H5UploadActivity.5
                @Override // com.yanzhenjie.permission.a
                public void onAction(List<String> list) {
                    H5UploadActivity.this.f();
                }
            }).start();
        } else {
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        Uri eaL = eaL();
        this.nYm = eaL;
        if (Build.VERSION.SDK_INT < 24) {
            intent.putExtra("output", eaL);
        } else {
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("_data", eaL.getPath());
            contentValues.put("mime_type", MimeType.Image.JPEG);
            intent.putExtra("output", getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues));
        }
        if (tv.chushou.zues.utils.a.isIntentAvailable(this, intent)) {
            startActivityForResult(intent, 1001);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (!new com.yanzhenjie.permission.a.b().e(this.w, "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE")) {
            com.yanzhenjie.permission.b.gL(this.w).W("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE").a(new com.yanzhenjie.permission.g() { // from class: com.kascend.chushou.view.h5.H5UploadActivity.7
                @Override // com.yanzhenjie.permission.g
                public void showRationale(Context context, List<String> list, final com.yanzhenjie.permission.i iVar) {
                    List<String> c = com.yanzhenjie.permission.e.c(context, list);
                    final tv.chushou.zues.widget.sweetalert.b bVar = new tv.chushou.zues.widget.sweetalert.b(context);
                    bVar.a(new b.a() { // from class: com.kascend.chushou.view.h5.H5UploadActivity.7.2
                        @Override // tv.chushou.zues.widget.sweetalert.b.a
                        public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                            bVar.emV();
                            iVar.cancel();
                        }
                    }).b(new b.a() { // from class: com.kascend.chushou.view.h5.H5UploadActivity.7.1
                        @Override // tv.chushou.zues.widget.sweetalert.b.a
                        public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                            bVar.emV();
                            iVar.execute();
                        }
                    }).Xf(context.getString(a.i.alert_dialog_cancel)).Xh(context.getString(a.i.gallery_permissions_continue)).B(context.getString(a.i.gallery_permissions_rationale, c)).setCanceledOnTouchOutside(false);
                    bVar.show();
                }
            }).b(new com.yanzhenjie.permission.a() { // from class: com.kascend.chushou.view.h5.H5UploadActivity.9
                @Override // com.yanzhenjie.permission.a
                public void onAction(List<String> list) {
                    g.OF(a.i.gallery_sdcard_permission_denied);
                }
            }).a(new com.yanzhenjie.permission.a() { // from class: com.kascend.chushou.view.h5.H5UploadActivity.8
                @Override // com.yanzhenjie.permission.a
                public void onAction(List<String> list) {
                    H5UploadActivity.this.h();
                }
            }).start();
        } else {
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (Build.VERSION.SDK_INT <= 19) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("image/*");
            startActivityForResult(intent, 1002);
            return;
        }
        Intent intent2 = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent2.addCategory("android.intent.category.OPENABLE");
        intent2.setType("image/*");
        intent2.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent2, 1002);
    }
}
