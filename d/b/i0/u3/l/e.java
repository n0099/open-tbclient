package d.b.i0.u3.l;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.write.album.AlbumImageBrowseFragment;
import com.baidu.tieba.write.album.ImageListFragment;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.Serializable;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class e implements d.b.h0.t0.a, View.OnClickListener {
    public Intent B;

    /* renamed from: e  reason: collision with root package name */
    public int f61607e;

    /* renamed from: f  reason: collision with root package name */
    public int f61608f;
    public BaseFragmentActivity i;
    public c j;
    public d.b.i0.u3.l.a k;
    public f l;
    public j m;
    public int o;
    public FrsTabInfoData x;

    /* renamed from: g  reason: collision with root package name */
    public int f61609g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f61610h = false;
    public String n = "";
    public String p = "";
    public String q = "";
    public String r = "0";
    public int s = 0;
    public int t = 0;
    public boolean u = false;
    public boolean v = true;
    public boolean w = false;
    public boolean y = false;
    public int z = 0;
    public int A = -1;
    public PostPrefixData C = null;
    public AntiData D = null;
    public String E = "";
    public String F = "";

    /* loaded from: classes5.dex */
    public class a implements f {
        public a() {
        }

        @Override // d.b.i0.u3.l.f
        public boolean a(ImageFileInfo imageFileInfo) {
            if (imageFileInfo != null) {
                String filePath = imageFileInfo.getFilePath();
                if (!StringUtils.isNULL(filePath)) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(filePath, options);
                    int i = options.outWidth;
                    if (options.outHeight >= 200 && i >= 200) {
                        return true;
                    }
                }
            }
            BdToast.i(e.this.i, e.this.i.getString(R.string.uploade_attation), R.drawable.icon_toast_game_error, false).q();
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        public b() {
        }

        public /* synthetic */ b(e eVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            new d.b.h0.b0.f(null).m(e.this.j.m(), true);
            return e.this.j.m().toJsonString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Intent intent = new Intent();
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, str);
            e.this.i.setResult(-1, intent);
            e.this.i.finish();
        }
    }

    public e(BaseFragmentActivity baseFragmentActivity, Bundle bundle, int i, int i2) {
        q(baseFragmentActivity, i, i2);
        if (bundle == null) {
            r(this.i.getIntent());
        } else {
            s(bundle);
        }
        Q(0, this.f61607e);
    }

    public void A() {
        G();
        j jVar = this.m;
        if (jVar != null) {
            jVar.k();
        }
    }

    public void B(Bundle bundle) {
        bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.j.m().toJsonString());
        bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.w);
        bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.s);
        bundle.putString("forum_id", this.r);
        bundle.putString("forum_name", this.q);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.t);
        bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO, this.u);
        bundle.putBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY, this.y);
        bundle.putSerializable("tab_list", this.x);
        bundle.putSerializable("anti_data", this.D);
        bundle.putSerializable("prefix_data", this.C);
        bundle.putString(IntentConfig.FORUM_FIRST_DIR, this.E);
        bundle.putString(IntentConfig.FORUM_SECOND_DIR, this.F);
    }

    public void E() {
        j jVar = this.m;
        if (jVar != null) {
            jVar.l();
        }
    }

    public void F() {
        j jVar = this.m;
        if (jVar != null) {
            jVar.m();
        }
    }

    public final void G() {
        d.b.i0.u3.l.a aVar = this.k;
        if (aVar != null) {
            aVar.s();
        }
    }

    public void I(Intent intent) {
        this.B = intent;
        if (intent != null && this.j != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                WriteImagesInfo m = this.j.m();
                m.parseJson(stringExtra);
                m.updateQuality();
                m(intent);
                return;
            }
            return;
        }
        m(null);
    }

    public final void J(ImageFileInfo imageFileInfo, boolean z) {
        Fragment k;
        d.b.i0.u3.l.a aVar = this.k;
        if (aVar == null || (k = aVar.k(1)) == null || !(k instanceof AlbumImageBrowseFragment)) {
            return;
        }
        ((AlbumImageBrowseFragment) k).V0(imageFileInfo, z);
    }

    public void K(ImageFileInfo imageFileInfo, boolean z) {
        Fragment k;
        d.b.i0.u3.l.a aVar = this.k;
        if (aVar == null || (k = aVar.k(0)) == null || !(k instanceof ImageListFragment)) {
            return;
        }
        ((ImageListFragment) k).d1(imageFileInfo, z);
    }

    public void L() {
        d.b.i0.u3.l.a aVar;
        c cVar = this.j;
        if (cVar == null || (aVar = this.k) == null) {
            return;
        }
        aVar.v(cVar.s());
    }

    public final boolean M() {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(this.i, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.i, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(this.i, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        return permissionJudgePolicy.startRequestPermission(this.i);
    }

    public void O(NavigationBar navigationBar) {
        if (navigationBar != null) {
            this.k.w(navigationBar);
        }
    }

    public void P(int i) {
        if (i == 1) {
            Q(i, this.f61608f);
        } else {
            Q(i, this.f61607e);
        }
    }

    public final void Q(int i, int i2) {
        if (this.f61610h) {
            return;
        }
        FragmentTransaction beginTransaction = this.i.getSupportFragmentManager().beginTransaction();
        Fragment findFragmentByTag = this.i.getSupportFragmentManager().findFragmentByTag(this.k.l(this.f61609g));
        if (findFragmentByTag != null) {
            beginTransaction.hide(findFragmentByTag);
        }
        this.f61609g = i;
        if (this.i.getSupportFragmentManager().findFragmentByTag(this.k.l(i)) != null) {
            beginTransaction.show(this.k.k(i));
        } else {
            beginTransaction.add(i2, this.k.k(i), this.k.l(i));
        }
        beginTransaction.commitAllowingStateLoss();
        this.i.getSupportFragmentManager().executePendingTransactions();
    }

    public final void R() {
        d.b.i0.u3.l.a aVar = this.k;
        if (aVar != null) {
            aVar.y();
        }
    }

    public final void S(int i) {
        c cVar;
        if (this.k == null || (cVar = this.j) == null) {
            return;
        }
        cVar.B(!cVar.s());
        L();
        d(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.tbadk.core.atomData.RecordVideoActivityConfig, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14, types: [com.baidu.tbadk.core.data.PostPrefixData] */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r1v14, types: [com.baidu.tbadk.core.data.PostPrefixData] */
    public void T(TbPageContext tbPageContext) {
        String str;
        ?? r12;
        if (!M() && d.b.i0.u3.j.b()) {
            ForumWriteData forumWriteData = new ForumWriteData(this.r, this.q, null, null);
            forumWriteData.statisticFrom = this.o;
            ?? recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.y ? 2 : 3, forumWriteData, this.j.m(), "", this.z);
            recordVideoActivityConfig.setShowType(!this.u ? 1 : 0);
            if (this.u) {
                String str2 = "";
                if (this.i.getIntent() != null) {
                    Serializable serializableExtra = this.i.getIntent().getSerializableExtra("anti_data");
                    AntiData antiData = serializableExtra instanceof AntiData ? (AntiData) serializableExtra : null;
                    Serializable serializableExtra2 = this.i.getIntent().getSerializableExtra("prefix_data");
                    r8 = serializableExtra2 instanceof PostPrefixData ? (PostPrefixData) serializableExtra2 : null;
                    str2 = this.i.getIntent().getStringExtra(IntentConfig.FORUM_FIRST_DIR);
                    str = this.i.getIntent().getStringExtra(IntentConfig.FORUM_SECOND_DIR);
                    AntiData antiData2 = r8;
                    r8 = antiData;
                    r12 = antiData2;
                } else {
                    str = "";
                    r12 = 0;
                }
                recordVideoActivityConfig.setExtraData(r8, r12, str2, str);
            }
            this.i.sendMessage(new CustomMessage(2002001, recordVideoActivityConfig));
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", 5).param("obj_type", 2));
        }
    }

    public boolean c(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        int l = this.j.l();
        if (this.j.D() < l) {
            f fVar = this.l;
            if (fVar == null || fVar.a(imageFileInfo)) {
                ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                imageFileInfo2.setContentUriStr(imageFileInfo.getContentUriStr());
                imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                imageFileInfo2.setIsGif(imageFileInfo.isGif());
                imageFileInfo2.setIsLong(imageFileInfo.isLong());
                this.j.w(null);
                this.j.a(imageFileInfo2);
                L();
                return true;
            }
            return false;
        } else if (j()) {
            return c(imageFileInfo);
        } else {
            this.i.showToast(String.format(this.i.getString(R.string.max_choose_image_count), Integer.valueOf(l)));
            return false;
        }
    }

    public final void d(int i) {
        c cVar = this.j;
        if (cVar == null || !cVar.s() || StringUtils.isNull(this.p, true) || StringUtils.isNull(this.r, true)) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c10349").param("fid", this.r).param("obj_type", this.p).param("obj_locate", i));
    }

    public boolean e() {
        return this.u;
    }

    public final void f() {
        if (this.s == 2) {
            this.l = new a();
        }
    }

    @Override // d.b.h0.t0.a
    public Intent getResultIntent() {
        return null;
    }

    public void h() {
        if (this.s == 3) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
        }
        if (this.s == 5) {
            this.i.showLoadingDialog("正在上传");
            new b(this, null).execute(new String[0]);
        } else if (this.j == null) {
        } else {
            j jVar = this.m;
            if (jVar == null || !jVar.i()) {
                if (this.j.p()) {
                    VideoFileInfo f2 = this.j.f();
                    if (this.m == null) {
                        j jVar2 = new j(this.i, this.q, this.r, "");
                        this.m = jVar2;
                        jVar2.p(this.x);
                        this.m.o(this.D, this.C, this.E, this.F);
                        d.b.i0.u3.l.a aVar = this.k;
                        if (aVar != null) {
                            aVar.x(this.m);
                        }
                    }
                    this.m.q(this.A);
                    this.m.r(this.o);
                    this.m.g(f2, this.n, this.p);
                } else if (this.v && v()) {
                    u();
                } else {
                    m(null);
                }
            }
        }
    }

    public boolean i(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return false;
        }
        this.j.w(null);
        this.j.c(imageFileInfo);
        L();
        return true;
    }

    @Override // d.b.h0.t0.a
    public boolean isOnViewCancel() {
        return true;
    }

    @Override // d.b.h0.t0.a
    public boolean isOnViewTop() {
        d.b.i0.u3.l.a aVar = this.k;
        if (aVar == null || aVar.m() == null || this.k.m().Y0() == null) {
            return true;
        }
        return this.k.m().Y0().getFirstVisiblePosition() == 0 && !this.k.m().Y0().canScrollVertically(-1);
    }

    public final boolean j() {
        int l;
        if (this.i.getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false) && this.j.D() == (l = this.j.l()) && l == 1) {
            try {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.j.g(), 0);
                if (i(imageFileInfo)) {
                    K(imageFileInfo, false);
                    J(imageFileInfo, false);
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public final void k() {
        Intent intent = new Intent();
        String k = this.j.k();
        if (TextUtils.isEmpty(k)) {
            k = "";
        }
        intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, k);
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.s);
        this.i.setResult(0, intent);
        this.i.finish();
    }

    public void l(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return;
        }
        Intent intent = new Intent();
        LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
        linkedList.add(imageFileInfo);
        this.j.m().setChosedFiles(linkedList);
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.j.m().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.s);
        intent.putExtra("from_type", this.z);
        this.i.setResult(-1, intent);
        this.i.finish();
    }

    public final void m(Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.j.m().toJsonString());
        intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.s);
        intent2.putExtra("from_type", this.z);
        if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
            intent2.putExtra("file_name", intent.getStringExtra("file_name"));
        }
        this.i.setResult(-1, intent2);
        this.i.finish();
        if (AlbumActivityConfig.FROM_FLUTTER.equals(this.p)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921464, intent2));
        }
    }

    public final int n() {
        c cVar = this.j;
        if (cVar != null && ListUtils.getCount(cVar.g()) != 0) {
            for (int i = 0; i < ListUtils.getCount(this.j.g()); i++) {
                ImageFileInfo imageFileInfo = this.j.g().get(i);
                if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                    return i;
                }
            }
        }
        return 0;
    }

    public int o() {
        return this.t;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.k.h()) {
            h();
        } else if (view == this.k.f()) {
            h();
        } else if (view == this.k.e()) {
            c cVar = this.j;
            if (cVar != null) {
                cVar.A(null);
            }
            k();
        } else if (view == this.k.d()) {
            Q(0, this.f61607e);
        } else if (view == this.k.o()) {
            S(2);
        } else if (view == this.k.n()) {
            S(1);
        }
    }

    @Override // d.b.h0.t0.a
    public void onViewChangeSkinType(int i) {
        d.b.i0.u3.l.a aVar = this.k;
        if (aVar != null) {
            aVar.onChangeSkinType(i);
        }
    }

    public c p() {
        return this.j;
    }

    public final void q(BaseFragmentActivity baseFragmentActivity, int i, int i2) {
        this.i = baseFragmentActivity;
        this.f61607e = i;
        this.f61608f = i2;
        d.b.i0.u3.l.a aVar = new d.b.i0.u3.l.a(baseFragmentActivity.getPageContext(), this);
        this.k = aVar;
        aVar.q();
    }

    public final void r(Intent intent) {
        this.j = new c(this.i.getPageContext());
        if (intent != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.j.C(writeImagesInfo);
            this.j.B(writeImagesInfo.isOriginalImg());
            this.w = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.s = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.p = intent.getStringExtra("from");
            this.r = intent.getStringExtra("forum_id");
            this.q = intent.getStringExtra("forum_name");
            this.t = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
            this.u = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_VIDEO, false);
            this.v = intent.getBooleanExtra(IntentConfig.KEY_CAN_EDIT_IMAGE, true);
            this.y = intent.getBooleanExtra(IntentConfig.KEY_FROM_WRITEACTIVITY, false);
            this.n = intent.getStringExtra("KEY_CALL_FROM");
            this.o = intent.getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0);
            this.z = intent.getIntExtra("from_type", 0);
            this.x = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.A = intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
            Serializable serializableExtra = intent.getSerializableExtra("anti_data");
            if (serializableExtra instanceof AntiData) {
                this.D = (AntiData) serializableExtra;
            }
            Serializable serializableExtra2 = intent.getSerializableExtra("prefix_data");
            if (serializableExtra2 instanceof PostPrefixData) {
                this.C = (PostPrefixData) serializableExtra2;
            }
            this.E = intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR);
            this.F = intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR);
        }
        f();
    }

    public final void s(Bundle bundle) {
        this.j = new c(this.i.getPageContext());
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
            this.j.C(writeImagesInfo);
            this.w = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
            this.s = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
            this.r = bundle.getString("forum_id");
            this.q = bundle.getString("forum_name");
            this.t = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            this.u = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO);
            this.y = bundle.getBoolean(IntentConfig.KEY_FROM_WRITEACTIVITY);
            this.n = bundle.getString("KEY_CALL_FROM");
            this.o = bundle.getInt(WriteActivityConfig.KEY_STATISTIS_FROM);
            this.z = bundle.getInt("from_type");
            this.x = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.p = bundle.getString("from");
            this.A = bundle.getInt(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
            Serializable serializable = bundle.getSerializable("anti_data");
            if (serializable instanceof AntiData) {
                this.D = (AntiData) serializable;
            }
            Serializable serializable2 = bundle.getSerializable("prefix_data");
            if (serializable2 instanceof PostPrefixData) {
                this.C = (PostPrefixData) serializable2;
            }
            this.E = bundle.getString(IntentConfig.FORUM_FIRST_DIR, "");
            this.F = bundle.getString(IntentConfig.FORUM_SECOND_DIR, "");
        }
        f();
    }

    public final void u() {
        WriteImagesInfo m;
        c cVar = this.j;
        if (cVar == null || (m = cVar.m()) == null) {
            return;
        }
        this.i.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.i, 12012, m, n())));
    }

    public final boolean v() {
        c cVar = this.j;
        if (cVar == null || ListUtils.getCount(cVar.g()) == 0) {
            return false;
        }
        int i = 0;
        for (ImageFileInfo imageFileInfo : this.j.g()) {
            if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                return false;
            }
        }
        return i == 1;
    }

    public void w() {
        this.i.closeLoadingDialog();
        int i = this.f61609g;
        if (i != 0) {
            if (i == 1) {
                P(0);
                return;
            }
            return;
        }
        c cVar = this.j;
        if (cVar != null) {
            cVar.A(null);
        }
        k();
    }

    public void x() {
        this.f61610h = true;
        R();
        this.i.closeLoadingDialog();
        this.i.dismissAllDialog();
        d.f().e();
        d.b.i0.u3.l.a aVar = this.k;
        if (aVar != null) {
            aVar.r();
        }
        j jVar = this.m;
        if (jVar != null) {
            jVar.j();
        }
        Intent intent = new Intent();
        intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.j.m().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.s);
        intent.putExtra("from_type", this.z);
        Intent intent2 = this.B;
        if (intent2 != null && !StringUtils.isNull(intent2.getStringExtra("file_name"))) {
            intent.putExtra("file_name", this.B.getStringExtra("file_name"));
        }
        TbadkCoreApplication.getInst().sendBroadcast(intent);
    }

    public void y() {
        R();
    }

    public void z(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        d.b.i0.u3.l.a aVar = this.k;
        if (aVar != null) {
            aVar.u();
        }
    }
}
