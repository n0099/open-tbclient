package com.repackage;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.TbCaptureActivityConfig;
import com.baidu.tbadk.core.atomData.VideoCoverSelectActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishManager;
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
import com.baidu.tbadk.img.ImageUploader;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.write.album.AlbumImageBrowseFragment;
import com.baidu.tieba.write.album.ImageListFragment;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.auth.NTLMEngineImpl;
import com.google.protobuf.CodedInputStream;
import java.io.Serializable;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class yv8 implements f95, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static int M = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsTabInfoData A;
    public int B;
    public int C;
    public int D;
    public Intent E;
    public boolean F;
    public PostPrefixData G;
    public AntiData H;
    public String I;
    public String J;
    public CustomMessageListener K;
    public CustomMessageListener L;
    public int a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public BaseFragmentActivity f;
    public wv8 g;
    public uv8 h;
    public zv8 i;
    public dw8 j;
    public String k;
    public int l;
    public String m;
    public String n;
    public String o;
    public int p;
    public int q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yv8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(yv8 yv8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yv8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.f == null) {
                return;
            }
            this.a.f.finish();
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yv8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(yv8 yv8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yv8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.f == null) {
                return;
            }
            this.a.f.closeLoadingDialog();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements zv8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yv8 a;

        public c(yv8 yv8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yv8Var;
        }

        @Override // com.repackage.zv8
        public boolean a(ImageFileInfo imageFileInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageFileInfo)) == null) {
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
                BdToast.i(this.a.f, this.a.f.getString(R.string.obfuscated_res_0x7f0f14e8), R.drawable.obfuscated_res_0x7f080a7a, false).n();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yv8 a;

        public d(yv8 yv8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yv8Var;
        }

        public /* synthetic */ d(yv8 yv8Var, a aVar) {
            this(yv8Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                new ImageUploader(null).uploadInBackgroundIgnoreAlreadyUploaded(this.a.g.m(), true);
                return this.a.g.m().toJsonString();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                Intent intent = new Intent();
                intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, str);
                this.a.f.setResult(-1, intent);
                this.a.f.finish();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755128234, "Lcom/repackage/yv8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755128234, "Lcom/repackage/yv8;");
        }
    }

    public yv8(BaseFragmentActivity baseFragmentActivity, Bundle bundle, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, bundle, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.d = false;
        this.e = false;
        this.k = "";
        this.m = "";
        this.n = "";
        this.o = "0";
        this.p = 0;
        this.q = 0;
        this.r = false;
        this.s = false;
        this.t = true;
        this.u = true;
        this.v = false;
        this.x = false;
        this.y = true;
        this.z = false;
        this.B = 5;
        this.C = 0;
        this.D = -1;
        this.G = null;
        this.H = null;
        this.I = "";
        this.J = "";
        this.K = new a(this, 2921583);
        this.L = new b(this, 2921614);
        t(baseFragmentActivity, i, i2);
        if (bundle == null) {
            u(this.f.getIntent());
        } else {
            v(bundle);
        }
        S(0, this.a);
        BaseFragmentActivity baseFragmentActivity2 = this.f;
        if (baseFragmentActivity2 != null) {
            baseFragmentActivity2.registerListener(this.K);
            this.f.registerListener(this.L);
        }
    }

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            wv8 wv8Var = this.g;
            if (wv8Var == null || ListUtils.getCount(wv8Var.g()) == 0) {
                return false;
            }
            int i = 0;
            for (ImageFileInfo imageFileInfo : this.g.g()) {
                if (imageFileInfo != null && imageFileInfo.getImageType() == 0 && (i = i + 1) >= 2) {
                    return false;
                }
            }
            return i == 1;
        }
        return invokeV.booleanValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f.closeLoadingDialog();
            int i = this.c;
            if (i != 0) {
                if (i == 1) {
                    R(0);
                    return;
                }
                return;
            }
            wv8 wv8Var = this.g;
            if (wv8Var != null) {
                wv8Var.A(null);
            }
            l();
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            T();
        }
    }

    public void E(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        uv8 uv8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048579, this, i, strArr, iArr) == null) || (uv8Var = this.h) == null) {
            return;
        }
        uv8Var.u();
    }

    public void F(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            bundle.putString(AlbumActivityConfig.WRITE_IMAGES_INFO, this.g.m().toJsonString());
            bundle.putBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, this.x);
            bundle.putInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.p);
            bundle.putString("forum_id", this.o);
            bundle.putString("forum_name", this.n);
            bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.q);
            bundle.putBoolean(AlbumActivityConfig.KEY_ALBUM_SHOW_CAPTURE, this.y);
            bundle.putBoolean(AlbumActivityConfig.KEY_ALBUM_DIRECT_DONE_ONLY_ONE, this.z);
            bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO, this.r);
            bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_ONLY_VIDEO, this.s);
            bundle.putBoolean(IntentConfig.KEY_CAN_SELECT_GIF, this.t);
            bundle.putBoolean(IntentConfig.KEY_NEED_CLIP_IMAGE, this.v);
            bundle.putInt(IntentConfig.KEY_IMAGE_CLIP_TYPE, this.w);
            bundle.putInt(IntentConfig.KEY_FROM_WRITE_TYPE, this.B);
            bundle.putSerializable("tab_list", this.A);
            bundle.putSerializable("anti_data", this.H);
            bundle.putSerializable("prefix_data", this.G);
            bundle.putString(IntentConfig.FORUM_FIRST_DIR, this.I);
            bundle.putString(IntentConfig.FORUM_SECOND_DIR, this.J);
        }
    }

    public void G() {
        dw8 dw8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (dw8Var = this.j) == null) {
            return;
        }
        dw8Var.l();
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            dw8 dw8Var = this.j;
            if (dw8Var != null) {
                dw8Var.m();
            }
            if (this.e) {
                this.f.finish();
            }
        }
    }

    @Override // com.repackage.f95
    public boolean H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void I() {
        uv8 uv8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (uv8Var = this.h) == null) {
            return;
        }
        uv8Var.t();
    }

    public void J(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, intent) == null) {
            this.E = intent;
            if (intent != null && this.g != null) {
                String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
                if (stringExtra != null) {
                    WriteImagesInfo m = this.g.m();
                    m.parseJson(stringExtra);
                    m.updateQuality();
                    o(intent);
                    return;
                } else if (intent == null || StringUtils.isNull(intent.getStringExtra(VideoCoverSelectActivityConfig.KEY_VIDEO_COVER_IMAGE_PATH))) {
                    return;
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra(VideoCoverSelectActivityConfig.KEY_VIDEO_COVER_IMAGE_PATH, intent.getStringExtra(VideoCoverSelectActivityConfig.KEY_VIDEO_COVER_IMAGE_PATH));
                    this.f.setResult(-1, intent2);
                    this.f.finish();
                    return;
                }
            }
            o(null);
        }
    }

    public final void L(ImageFileInfo imageFileInfo, boolean z) {
        uv8 uv8Var;
        Fragment m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048586, this, imageFileInfo, z) == null) || (uv8Var = this.h) == null || (m = uv8Var.m(1)) == null || !(m instanceof AlbumImageBrowseFragment)) {
            return;
        }
        ((AlbumImageBrowseFragment) m).J1(imageFileInfo, z);
    }

    public void M(ImageFileInfo imageFileInfo, boolean z) {
        uv8 uv8Var;
        Fragment m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, imageFileInfo, z) == null) || (uv8Var = this.h) == null || (m = uv8Var.m(0)) == null || !(m instanceof ImageListFragment)) {
            return;
        }
        ((ImageListFragment) m).S1(imageFileInfo, z);
    }

    public void N() {
        wv8 wv8Var;
        uv8 uv8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (wv8Var = this.g) == null || (uv8Var = this.h) == null) {
            return;
        }
        uv8Var.v(wv8Var.s());
    }

    public final boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(this.f, "android.permission.CAMERA");
            permissionJudgePolicy.appendRequestPermission(this.f, "android.permission.RECORD_AUDIO");
            permissionJudgePolicy.appendRequestPermission(this.f, "android.permission.WRITE_EXTERNAL_STORAGE");
            return permissionJudgePolicy.startRequestPermission(this.f);
        }
        return invokeV.booleanValue;
    }

    public final boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(this.f, "android.permission.CAMERA");
            permissionJudgePolicy.appendRequestPermission(this.f, "android.permission.WRITE_EXTERNAL_STORAGE");
            return permissionJudgePolicy.startRequestPermission(this.f);
        }
        return invokeV.booleanValue;
    }

    public void Q(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, navigationBar) == null) || navigationBar == null) {
            return;
        }
        this.h.w(navigationBar);
    }

    public void R(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            if (i == 1) {
                S(i, this.b);
            } else {
                S(i, this.a);
            }
        }
    }

    public final void S(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048593, this, i, i2) == null) || this.d) {
            return;
        }
        FragmentTransaction beginTransaction = this.f.getSupportFragmentManager().beginTransaction();
        Fragment findFragmentByTag = this.f.getSupportFragmentManager().findFragmentByTag(this.h.n(this.c));
        if (findFragmentByTag != null) {
            beginTransaction.hide(findFragmentByTag);
        }
        this.c = i;
        if (this.f.getSupportFragmentManager().findFragmentByTag(this.h.n(i)) != null) {
            beginTransaction.show(this.h.m(i));
        } else {
            beginTransaction.add(i2, this.h.m(i), this.h.n(i));
        }
        beginTransaction.commitAllowingStateLoss();
        this.f.getSupportFragmentManager().executePendingTransactions();
    }

    public final void T() {
        uv8 uv8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (uv8Var = this.h) == null) {
            return;
        }
        uv8Var.y();
    }

    public final void U(int i) {
        wv8 wv8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i) == null) || this.h == null || (wv8Var = this.g) == null) {
            return;
        }
        wv8Var.B(!wv8Var.s());
        N();
        d(i);
    }

    public void V(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, tbPageContext) == null) {
            if (this.r && this.s) {
                if (O()) {
                    return;
                }
                this.f.showLoadingDialog(null);
                TbCaptureActivityConfig tbCaptureActivityConfig = new TbCaptureActivityConfig(tbPageContext.getPageActivity());
                tbCaptureActivityConfig.getIntent().putExtras(this.f.getIntent());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbCaptureActivityConfig));
                this.e = true;
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", 5).param("obj_type", 2));
                if (WorkPublishManager.isWorkPublishLocate()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WORK_PUBLISH_ENTER_TYPE_CLICK).param("obj_locate", 1).param("obj_source", WorkPublishManager.isWorkPublishLocateVideoCenter() ? 2 : 1));
                }
            } else if (!rv8.d() || P()) {
            } else {
                ForumWriteData forumWriteData = new ForumWriteData(this.o, this.n, null, null);
                forumWriteData.statisticFrom = this.l;
                this.f.showLoadingDialog(null);
                RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), this.B != 5 ? 2 : 3, forumWriteData, this.g.m(), "", this.C);
                recordVideoActivityConfig.getIntent().putExtras(this.f.getIntent());
                recordVideoActivityConfig.setShowType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921615, recordVideoActivityConfig));
                this.e = false;
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", 5).param("obj_type", 2));
            }
        }
    }

    public boolean c(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, imageFileInfo)) == null) {
            if (imageFileInfo == null) {
                return false;
            }
            int l = this.g.l();
            if (this.g.D() < l) {
                zv8 zv8Var = this.i;
                if (zv8Var == null || zv8Var.a(imageFileInfo)) {
                    ImageFileInfo imageFileInfo2 = new ImageFileInfo();
                    imageFileInfo2.setAlbumnId(imageFileInfo.getAlbumId());
                    imageFileInfo2.setContentUriStr(imageFileInfo.getContentUriStr());
                    imageFileInfo2.setFilePath(imageFileInfo.getFilePath());
                    imageFileInfo2.setModifyTime(imageFileInfo.getModifyTime());
                    imageFileInfo2.setIsGif(imageFileInfo.isGif());
                    imageFileInfo2.setIsLong(imageFileInfo.isLong());
                    this.g.w(null);
                    this.g.a(imageFileInfo2);
                    N();
                    return true;
                }
                return false;
            } else if (k()) {
                return c(imageFileInfo);
            } else {
                String format = String.format(this.f.getString(R.string.obfuscated_res_0x7f0f0aa6), Integer.valueOf(l));
                if (l == M) {
                    BdTopToast bdTopToast = new BdTopToast(this.f);
                    bdTopToast.i(false);
                    bdTopToast.h(format);
                    bdTopToast.j((ViewGroup) this.f.findViewById(R.id.obfuscated_res_0x7f091dc6));
                } else {
                    this.f.showToast(format);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final void d(int i) {
        wv8 wv8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i) == null) || (wv8Var = this.g) == null || !wv8Var.s() || StringUtils.isNull(this.m, true) || StringUtils.isNull(this.o, true)) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c10349").param("fid", this.o).param("obj_type", this.m).param("obj_locate", i));
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.r : invokeV.booleanValue;
    }

    @Override // com.repackage.f95
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && this.p == 2) {
            this.i = new c(this);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (this.p == 3) {
                TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_DIALOG_CHOOSE_IMAGE);
            }
            int i = this.p;
            if (i != 5 && i != 6) {
                if (this.g == null) {
                    return;
                }
                dw8 dw8Var = this.j;
                if (dw8Var == null || !dw8Var.i()) {
                    if (this.g.p()) {
                        VideoFileInfo f = this.g.f();
                        if (this.j == null) {
                            dw8 dw8Var2 = new dw8(this.f, this.n, this.o, "");
                            this.j = dw8Var2;
                            dw8Var2.p(this.A);
                            this.j.o(this.H, this.G, this.I, this.J);
                            uv8 uv8Var = this.h;
                            if (uv8Var != null) {
                                uv8Var.x(this.j);
                            }
                        }
                        this.j.q(this.D);
                        this.j.r(this.l);
                        this.j.g(f, this.k, this.m);
                        return;
                    } else if (this.u && A()) {
                        z();
                        return;
                    } else if (this.B == 4) {
                        if (WriteActivityConfig.isAsyncWriting()) {
                            return;
                        }
                        WriteActivityConfig newInstance = WriteActivityConfig.newInstance(this.f);
                        newInstance.getIntent().setFlags(NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
                        newInstance.getIntent().setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                        newInstance.getIntent().putExtras(this.f.getIntent());
                        newInstance.setType(9).setForumId(TextUtils.isEmpty(this.o) ? "0" : this.o).setWriteImagesInfo(this.g.m()).send();
                        newInstance.setRichModeEnable(this.F);
                        this.f.finish();
                        return;
                    } else if (this.v) {
                        y();
                        return;
                    } else {
                        o(null);
                        return;
                    }
                }
                return;
            }
            this.f.showLoadingDialog("正在上传");
            new d(this, null).execute(new String[0]);
        }
    }

    public boolean j(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, imageFileInfo)) == null) {
            if (imageFileInfo == null) {
                return false;
            }
            this.g.w(null);
            this.g.c(imageFileInfo);
            N();
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        int l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.f.getIntent().getBooleanExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, false) && this.g.D() == (l = this.g.l()) && l == 1) {
                try {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.g.g(), 0);
                    if (j(imageFileInfo)) {
                        M(imageFileInfo, false);
                        L(imageFileInfo, false);
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            Intent intent = new Intent();
            String k = this.g.k();
            if (TextUtils.isEmpty(k)) {
                k = "";
            }
            intent.putExtra(AlbumActivityConfig.LAST_ALBUM_ID, k);
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.p);
            this.f.setResult(0, intent);
            this.f.finish();
        }
    }

    public void m(ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, imageFileInfo) == null) || imageFileInfo == null) {
            return;
        }
        Intent intent = new Intent();
        LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
        linkedList.add(imageFileInfo);
        this.g.m().setChosedFiles(linkedList);
        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.g.m().toJsonString());
        intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.p);
        intent.putExtra("from_type", this.C);
        this.f.setResult(-1, intent);
        this.f.finish();
    }

    @Override // com.repackage.f95
    public void n(int i) {
        uv8 uv8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048609, this, i) == null) || (uv8Var = this.h) == null) {
            return;
        }
        uv8Var.onChangeSkinType(i);
    }

    public final void o(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, intent) == null) {
            Intent intent2 = new Intent();
            intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.g.m().toJsonString());
            intent2.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.p);
            intent2.putExtra("from_type", this.C);
            if (intent != null && !StringUtils.isNull(intent.getStringExtra("file_name"))) {
                intent2.putExtra("file_name", intent.getStringExtra("file_name"));
            }
            this.f.setResult(-1, intent2);
            this.f.finish();
            if (AlbumActivityConfig.FROM_FLUTTER.equals(this.m)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921464, intent2));
            } else if (AlbumActivityConfig.FROM_FLUTTER_MULTI.equals(this.m)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921714, intent2));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, view2) == null) {
            if (view2 == this.h.k()) {
                i();
            } else if (view2 == this.h.j()) {
                i();
            } else if (view2 == this.h.h()) {
                wv8 wv8Var = this.g;
                if (wv8Var != null) {
                    wv8Var.A(null);
                }
                l();
            } else if (view2 == this.h.a()) {
                S(0, this.a);
            } else if (view2 == this.h.q()) {
                U(2);
            } else if (view2 == this.h.p()) {
                U(1);
            }
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.d = true;
            T();
            this.f.closeLoadingDialog();
            this.f.dismissAllDialog();
            xv8.f().e();
            uv8 uv8Var = this.h;
            if (uv8Var != null) {
                uv8Var.s();
            }
            dw8 dw8Var = this.j;
            if (dw8Var != null) {
                dw8Var.j();
            }
            Intent intent = new Intent();
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            intent.setAction(AlbumActivityConfig.ACTION_SELECT_IMAGE_RESULT);
            intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.g.m().toJsonString());
            intent.putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, this.p);
            intent.putExtra("from_type", this.C);
            Intent intent2 = this.E;
            if (intent2 != null && !StringUtils.isNull(intent2.getStringExtra("file_name"))) {
                intent.putExtra("file_name", this.E.getStringExtra("file_name"));
            }
            TbadkCoreApplication.getInst().sendBroadcast(intent);
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            I();
            dw8 dw8Var = this.j;
            if (dw8Var != null) {
                dw8Var.k();
            }
            this.e = false;
        }
    }

    public final int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            wv8 wv8Var = this.g;
            if (wv8Var != null && ListUtils.getCount(wv8Var.g()) != 0) {
                for (int i = 0; i < ListUtils.getCount(this.g.g()); i++) {
                    ImageFileInfo imageFileInfo = this.g.g().get(i);
                    if (imageFileInfo != null && imageFileInfo.getImageType() == 0) {
                        return i;
                    }
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.q : invokeV.intValue;
    }

    public wv8 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.g : (wv8) invokeV.objValue;
    }

    @Override // com.repackage.f95
    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            uv8 uv8Var = this.h;
            if (uv8Var == null || uv8Var.o() == null || this.h.o().N1() == null) {
                return true;
            }
            return this.h.o().N1().getFirstVisiblePosition() == 0 && !this.h.o().N1().canScrollVertically(-1);
        }
        return invokeV.booleanValue;
    }

    public final void t(BaseFragmentActivity baseFragmentActivity, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048618, this, baseFragmentActivity, i, i2) == null) {
            this.f = baseFragmentActivity;
            this.a = i;
            this.b = i2;
            uv8 uv8Var = new uv8(baseFragmentActivity.getPageContext(), this);
            this.h = uv8Var;
            uv8Var.r();
        }
    }

    public final void u(Intent intent) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, intent) == null) {
            this.g = new wv8(this.f.getPageContext());
            if (intent != null) {
                this.r = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_VIDEO, false);
                this.s = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_ONLY_VIDEO, false);
                this.t = intent.getBooleanExtra(IntentConfig.KEY_CAN_SELECT_GIF, true);
                if (this.r && this.s) {
                    writeImagesInfo = new WriteImagesInfo();
                } else {
                    writeImagesInfo = new WriteImagesInfo(9);
                }
                writeImagesInfo.parseJson(intent.getStringExtra(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.g.C(writeImagesInfo);
                this.g.B(writeImagesInfo.isOriginalImg());
                this.x = intent.getBooleanExtra(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.p = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.m = intent.getStringExtra("from");
                this.o = intent.getStringExtra("forum_id");
                this.n = intent.getStringExtra("forum_name");
                this.q = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
                this.y = intent.getBooleanExtra(AlbumActivityConfig.KEY_ALBUM_SHOW_CAPTURE, true);
                this.z = intent.getBooleanExtra(AlbumActivityConfig.KEY_ALBUM_DIRECT_DONE_ONLY_ONE, false);
                this.u = intent.getBooleanExtra(IntentConfig.KEY_CAN_EDIT_IMAGE, true);
                this.v = intent.getBooleanExtra(IntentConfig.KEY_NEED_CLIP_IMAGE, false);
                this.w = intent.getIntExtra(IntentConfig.KEY_IMAGE_CLIP_TYPE, 0);
                this.B = intent.getIntExtra(IntentConfig.KEY_FROM_WRITE_TYPE, 5);
                this.k = intent.getStringExtra("KEY_CALL_FROM");
                this.l = intent.getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0);
                this.C = intent.getIntExtra("from_type", 0);
                this.A = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
                this.D = intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
                Serializable serializableExtra = intent.getSerializableExtra("anti_data");
                if (serializableExtra instanceof AntiData) {
                    this.H = (AntiData) serializableExtra;
                }
                Serializable serializableExtra2 = intent.getSerializableExtra("prefix_data");
                if (serializableExtra2 instanceof PostPrefixData) {
                    this.G = (PostPrefixData) serializableExtra2;
                }
                this.I = intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR);
                this.J = intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR);
                this.F = intent.getBooleanExtra(WriteActivityConfig.RICH_MODE_ENABLE, false);
            }
            h();
        }
    }

    public final void v(Bundle bundle) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, bundle) == null) {
            this.g = new wv8(this.f.getPageContext());
            if (bundle != null) {
                this.r = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_VIDEO);
                this.s = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_ONLY_VIDEO);
                this.t = bundle.getBoolean(IntentConfig.KEY_CAN_SELECT_GIF);
                this.v = bundle.getBoolean(IntentConfig.KEY_NEED_CLIP_IMAGE, false);
                this.w = bundle.getInt(IntentConfig.KEY_IMAGE_CLIP_TYPE, 0);
                if (this.r && this.s) {
                    writeImagesInfo = new WriteImagesInfo();
                } else {
                    writeImagesInfo = new WriteImagesInfo(9);
                }
                writeImagesInfo.parseJson(bundle.getString(AlbumActivityConfig.WRITE_IMAGES_INFO));
                this.g.C(writeImagesInfo);
                this.x = bundle.getBoolean(AlbumActivityConfig.USE_ORIGINAL_IMG, false);
                this.p = bundle.getInt(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                this.o = bundle.getString("forum_id");
                this.n = bundle.getString("forum_name");
                this.q = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
                this.B = bundle.getInt(IntentConfig.KEY_FROM_WRITE_TYPE);
                this.y = bundle.getBoolean(AlbumActivityConfig.KEY_ALBUM_SHOW_CAPTURE);
                this.z = bundle.getBoolean(AlbumActivityConfig.KEY_ALBUM_DIRECT_DONE_ONLY_ONE);
                this.k = bundle.getString("KEY_CALL_FROM");
                this.l = bundle.getInt(WriteActivityConfig.KEY_STATISTIS_FROM);
                this.C = bundle.getInt("from_type");
                this.A = (FrsTabInfoData) bundle.getSerializable("tab_list");
                this.m = bundle.getString("from");
                this.D = bundle.getInt(WriteActivityConfig.KEY_PROFESSION_ZONE, -1);
                Serializable serializable = bundle.getSerializable("anti_data");
                if (serializable instanceof AntiData) {
                    this.H = (AntiData) serializable;
                }
                Serializable serializable2 = bundle.getSerializable("prefix_data");
                if (serializable2 instanceof PostPrefixData) {
                    this.G = (PostPrefixData) serializable2;
                }
                this.I = bundle.getString(IntentConfig.FORUM_FIRST_DIR, "");
                this.J = bundle.getString(IntentConfig.FORUM_SECOND_DIR, "");
                this.F = bundle.getBoolean(WriteActivityConfig.RICH_MODE_ENABLE, false);
            }
            h();
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.z : invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.y : invokeV.booleanValue;
    }

    public final void y() {
        wv8 wv8Var;
        WriteImagesInfo m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (wv8Var = this.g) == null || (m = wv8Var.m()) == null || m.getChosedFiles() == null || m.getChosedFiles().size() < 1) {
            return;
        }
        boolean booleanExtra = this.f.getIntent().getBooleanExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, false);
        VideoCoverSelectActivityConfig videoCoverSelectActivityConfig = new VideoCoverSelectActivityConfig(this.f);
        videoCoverSelectActivityConfig.setImagePath(m.getChosedFiles().getFirst().getFilePath());
        videoCoverSelectActivityConfig.getIntent().putExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, booleanExtra);
        videoCoverSelectActivityConfig.setVideoType(this.w);
        this.f.sendMessage(new CustomMessage(2002001, videoCoverSelectActivityConfig));
    }

    public final void z() {
        wv8 wv8Var;
        WriteImagesInfo m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048624, this) == null) || (wv8Var = this.g) == null || (m = wv8Var.m()) == null) {
            return;
        }
        this.f.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f, 12012, m, p())));
    }
}
