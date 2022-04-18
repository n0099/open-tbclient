package com.repackage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.text.TextWatcher;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.editortools.BLauncher;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.ImageModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cr4;
import com.repackage.fk8;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class m25 extends m05 implements fk8.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextWatcher A;
    public n25 B;
    public int C;
    public EditorTools D;
    public boolean E;
    public LocationModel.e F;
    public LocationModel.f G;
    public final NewWriteModel.g H;
    public final a9 I;
    public WriteImagesInfo b;
    public String c;
    public SpanGroupManager d;
    public VoiceData.VoiceModel e;
    public String f;
    public LocationModel g;
    public NewWriteModel h;
    public ImageModel i;
    public DataModel<?> j;
    public ForumData k;
    public ThreadData l;
    public String m;
    public TbPageContext n;
    public String o;
    public String p;
    public String q;
    public long r;
    public String s;
    public int t;
    public VideoInfo u;
    public boolean v;
    public NewWriteModel.g w;
    public k25 x;
    public j25 y;
    public boolean z;

    /* loaded from: classes6.dex */
    public class a implements LocationModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m25 a;

        public a(m25 m25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m25Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m25Var;
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.n.showToast(R.string.obfuscated_res_0x7f0f0c4e);
                this.a.b0(0, false, null);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void b(LocationData locationData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locationData) == null) {
                if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                    this.a.b0(2, true, locationData.getFormatted_address());
                } else {
                    onFail(null);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (this.a.E) {
                    TbPageContext tbPageContext = this.a.n;
                    if (StringUtils.isNull(str)) {
                        str = this.a.a().getContext().getString(R.string.obfuscated_res_0x7f0f0a42);
                    }
                    tbPageContext.showToast(str);
                }
                this.a.b0(0, false, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements LocationModel.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m25 a;

        public b(m25 m25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m25Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m25Var;
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b0(0, false, null);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.f
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.b0(2, true, str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(m25 m25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m25Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                vt4.k().u("key_post_thread_has_request_location", true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m25 a;

        public d(m25 m25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m25Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m25Var;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                this.a.b0(0, true, null);
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m25 a;

        public e(m25 m25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m25Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m25Var;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                if (mi.z()) {
                    this.a.b0(1, true, null);
                    this.a.g.N();
                } else {
                    this.a.F.a();
                }
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m25 a;

        public f(m25 m25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m25Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m25Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, qx4 qx4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, qx4Var, writeData, antiData}) == null) {
                if (writeData == null) {
                    writeData = this.a.h.b0();
                }
                if (z) {
                    this.a.Y(true);
                    WriteData b0 = this.a.h.b0();
                    this.a.S();
                    fk8.y(this.a.m, null);
                    if (b0 == null) {
                        return;
                    }
                    if (b0.getType() == 2) {
                        fk8.o(b0.getThreadId(), this.a);
                    }
                } else if (writeData != null && qx4Var != null && !TextUtils.isEmpty(qx4Var.d())) {
                    writeData.setVcodeMD5(qx4Var.b());
                    writeData.setVcodeUrl(qx4Var.c());
                    writeData.setVcodeExtra(qx4Var.a());
                    if (this.a.l != null) {
                        writeData.setBaijiahaoData(this.a.l.getBaijiahaoData());
                    }
                    if (qd5.b(qx4Var.d())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.n.getPageActivity(), 12006, writeData, false, qx4Var.d())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.n.getPageActivity(), writeData, 12006)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.n.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
                m25 m25Var = this.a;
                m25Var.G(m25Var.h.b0());
                NewWriteModel.g gVar = this.a.w;
                if (gVar != null) {
                    gVar.callback(z, postWriteCallBackData, qx4Var, writeData, antiData);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends BdAsyncTask<Void, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m25 a;

        public g(m25 m25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m25Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m25Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                FileHelper.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + this.a.f));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class h extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m25 a;

        public h(m25 m25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m25Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m25Var;
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof Bitmap)) {
                this.a.h.i0(true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m25(EditorTools editorTools) {
        super(editorTools);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {editorTools};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((EditorTools) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new WriteImagesInfo();
        this.c = "";
        this.h = null;
        this.i = null;
        this.m = null;
        this.o = null;
        this.t = 0;
        this.z = false;
        this.C = 0;
        this.E = true;
        this.F = new a(this);
        this.G = new b(this);
        this.H = new f(this);
        this.I = new h(this);
        this.D = editorTools;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.n.getPageActivity())));
        }
    }

    public boolean B() {
        InterceptResult invokeV;
        LinkedList<ImageFileInfo> chosedFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            WriteImagesInfo writeImagesInfo = this.b;
            return (writeImagesInfo == null || (chosedFiles = writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (StringUtils.isNull(this.c)) {
                WriteImagesInfo writeImagesInfo = this.b;
                if (writeImagesInfo == null || writeImagesInfo.size() <= 0) {
                    VoiceData.VoiceModel voiceModel = this.e;
                    if (voiceModel == null || StringUtils.isNull(voiceModel.getId())) {
                        VideoInfo videoInfo = this.u;
                        return videoInfo != null && videoInfo.isAvaliable();
                    }
                    return true;
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            VoiceData.VoiceModel voiceModel = this.e;
            return (voiceModel == null || TextUtils.isEmpty(voiceModel.voiceId) || this.e.duration <= 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.E = false;
        }
    }

    public void F(TbPageContext tbPageContext, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, tbPageContext, bundle) == null) {
            NewWriteModel newWriteModel = new NewWriteModel(tbPageContext);
            this.h = newWriteModel;
            newWriteModel.n0(this.H);
            ImageModel imageModel = new ImageModel(tbPageContext);
            this.i = imageModel;
            imageModel.setLoadDataCallBack(this.I);
            LocationModel locationModel = new LocationModel(tbPageContext);
            this.g = locationModel;
            locationModel.Q(this.F);
            this.g.R(this.G);
            if (bundle != null) {
                this.b.parseJson(bundle.getString("write_images"));
                this.f = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            WriteImagesInfo writeImagesInfo = this.b;
            if (writeImagesInfo != null) {
                writeImagesInfo.setMaxImagesAllowed(this.v ? 1 : 9);
            }
            if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && a() != null) {
                a().A(new i05(2, 12, " "));
            }
            if (!this.g.B() && a() != null) {
                a().A(new i05(20, 8, null));
            }
            WriteImagesInfo writeImagesInfo2 = this.b;
            if (writeImagesInfo2 == null || writeImagesInfo2.getChosedFiles() == null || this.b.getChosedFiles().size() <= 0) {
                return;
            }
            EditorTools a2 = a();
            a2.A(new i05(2, 10, this.b.getChosedFiles().size() + ""));
        }
    }

    public void G(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, writeData) == null) || writeData == null) {
            return;
        }
        this.b = new WriteImagesInfo();
        if (writeData.getWriteImagesInfo() != null) {
            this.b.copyFrom(writeData.getWriteImagesInfo());
            WriteImagesInfo writeImagesInfo = this.b;
            if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && this.b.getChosedFiles().size() > 0) {
                EditorTools a2 = a();
                a2.A(new i05(2, 10, this.b.getChosedFiles().size() + ""));
            }
        }
        WriteImagesInfo writeImagesInfo2 = this.b;
        if (writeImagesInfo2 == null || writeImagesInfo2.size() == 0) {
            a().A(new i05(2, 10, null));
        }
        String content = writeData.getContent();
        this.c = content;
        a0(content);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
    }

    public void H(int i, int i2, Intent intent) {
        ArrayList<AtSelectData> parcelableArrayListExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, intent) == null) {
            PostWriteCallBackData postWriteCallBackData = null;
            if (i2 != -1) {
                if (i == 12001) {
                    n();
                } else if (i == 12002) {
                    if (intent == null || !intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        return;
                    }
                    this.b.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                } else if (i != 12006) {
                } else {
                    if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    }
                    PostWriteCallBackData postWriteCallBackData2 = postWriteCallBackData;
                    NewWriteModel.g gVar = this.w;
                    if (gVar != null) {
                        gVar.callback(false, postWriteCallBackData2, null, this.h.b0(), null);
                    }
                }
            } else if (i == 11001) {
                L(null, null);
            } else if (i == 12006) {
                WriteData b0 = this.h.b0();
                PostWriteCallBackData postWriteCallBackData3 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                if (b0 != null) {
                    b0.deleteUploadedTempImages();
                }
                this.h.setWriteData(null);
                this.h.i0(false);
                this.e = null;
                this.u = null;
                if (!TextUtils.isEmpty(this.m)) {
                    fk8.y(this.m, null);
                }
                Y(true);
                NewWriteModel.g gVar2 = this.w;
                if (gVar2 != null) {
                    gVar2.callback(true, postWriteCallBackData3, null, b0, null);
                }
            } else if (i == 12012) {
                u(intent);
            } else if (i == 13010) {
                if (a() == null) {
                    return;
                }
                VideoInfo videoInfo = new VideoInfo();
                videoInfo.parseFromIntent(intent);
                if (videoInfo.isAvaliable()) {
                    this.u = videoInfo;
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.XIAOYING_DURATION);
                    statisticItem.param("duration", this.u.getVideoDuration());
                    TiebaStatic.log(statisticItem);
                    c0();
                    a().A(new i05(28, 20, this.u));
                    a().A(new i05(28, -1, this.u));
                }
            } else if (i == 23004) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
            } else if (i == 25004) {
                if (intent != null) {
                    W(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                }
            } else if (i == 11025) {
                AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.n.getPageActivity(), 12004, true);
                if (x() != null) {
                    atListActivityConfig.setSelectedAtList(x().u());
                }
                ThreadData threadData = this.l;
                if (threadData != null) {
                    atListActivityConfig.setFromTid(threadData.getTid());
                    atListActivityConfig.setFromFid(String.valueOf(this.l.getFid()));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                statisticItem2.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                ThreadData threadData2 = this.l;
                if (threadData2 != null) {
                    statisticItem2.addParam("tid", threadData2.getTid());
                    statisticItem2.addParam("fid", this.l.getFid());
                }
                TiebaStatic.log(statisticItem2);
            } else if (i == 11026) {
                AtListActivityConfig atListActivityConfig2 = new AtListActivityConfig(this.n.getPageActivity(), 12005, true);
                if (x() != null) {
                    atListActivityConfig2.setSelectedAtList(x().u());
                }
                ThreadData threadData3 = this.l;
                if (threadData3 != null) {
                    atListActivityConfig2.setFromTid(threadData3.getTid());
                    atListActivityConfig2.setFromFid(String.valueOf(this.l.getFid()));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig2));
                StatisticItem statisticItem3 = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                statisticItem3.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                ThreadData threadData4 = this.l;
                if (threadData4 != null) {
                    statisticItem3.addParam("tid", threadData4.getTid());
                    statisticItem3.addParam("fid", this.l.getFid());
                }
                TiebaStatic.log(statisticItem3);
            } else if (i == 12009 || i == 12010) {
                if (i == 12010) {
                    r(intent);
                }
            } else {
                switch (i) {
                    case TaskResponseData.ERROR_NO_TASK_OFFLINE_03 /* 12002 */:
                        if (intent == null) {
                            return;
                        }
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            r(intent);
                        } else {
                            q(intent);
                        }
                        a().invalidate();
                        return;
                    case 12003:
                        if (intent == null) {
                            return;
                        }
                        if (intent.getBooleanExtra("delete", false)) {
                            X();
                            this.h.i0(false);
                            return;
                        }
                        this.i.D(intent.getStringExtra("file_name"));
                        return;
                    case 12004:
                        if (intent == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA)) == null) {
                            return;
                        }
                        V(parcelableArrayListExtra);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.h.cancelLoadData();
            this.i.cancelLoadData();
            this.g.cancelLoadData();
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (PermissionUtil.checkLocationForGoogle(this.n.getPageActivity()) && z) {
                v0();
            } else {
                PermissionUtil.requestLocation(this.n.getPageActivity(), 0, new c(this));
            }
        }
    }

    public void K(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            WriteImagesInfo writeImagesInfo = this.b;
            if (writeImagesInfo != null) {
                bundle.putString("write_images", writeImagesInfo.toJsonString());
            }
            bundle.putString(WriteActivityConfig.PHOTO_NAME, this.f);
        }
    }

    public void L(String str, WriteData writeData) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, writeData) == null) {
            if (this.h.b0() == null) {
                WriteData F = this.j.F(str);
                if (F != null && (threadData = this.l) != null) {
                    F.setBaijiahaoData(threadData.getBaijiahaoData());
                }
                this.h.setWriteData(F);
            }
            if (this.h.b0() == null) {
                return;
            }
            this.h.setSpanGroupManager(this.d);
            boolean z = true;
            if (this.z) {
                this.h.b0().setCanNoForum(true);
                if (this.k != null) {
                    this.h.b0().setVForumId(this.k.getId());
                    this.h.b0().setVForumName(this.k.getName());
                }
            } else {
                this.h.b0().setCanNoForum(false);
                this.h.b0().setVForumId("");
                this.h.b0().setVForumName("");
            }
            this.h.b0().setIsBJHPost(this.v);
            this.h.b0().setWriteImagesInfo(this.b);
            this.h.b0().setVideoInfo(this.u);
            this.h.i0(this.b.size() > 0);
            WriteData b0 = this.h.b0();
            LocationModel locationModel = this.g;
            b0.setHasLocationData((locationModel == null || !locationModel.B()) ? false : false);
            if (str == null) {
                this.h.b0().setContent(this.c);
            }
            VoiceData.VoiceModel voiceModel = this.e;
            if (voiceModel != null) {
                if (voiceModel.getId() != null) {
                    this.h.b0().setVoice(this.e.getId());
                    this.h.b0().setVoiceDuringTime(this.e.duration);
                } else {
                    this.h.b0().setVoice(null);
                    this.h.b0().setVoiceDuringTime(-1);
                }
            } else {
                this.h.b0().setVoice(null);
                this.h.b0().setVoiceDuringTime(-1);
            }
            if (!this.h.Y()) {
                this.n.showToast(R.string.obfuscated_res_0x7f0f1586);
                return;
            }
            j25 j25Var = this.y;
            if (j25Var == null || !j25Var.a()) {
                k25 k25Var = this.x;
                if (k25Var != null) {
                    k25Var.a();
                }
                p(this.h.b0());
                o();
                if (!this.h.r0()) {
                }
            }
        }
    }

    public void M(AntiData antiData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, antiData) == null) || antiData == null) {
            return;
        }
        this.o = antiData.getVoice_message();
    }

    public void N(ForumData forumData, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, forumData, userData) == null) {
            this.k = forumData;
        }
    }

    public void O(MetaData metaData, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048590, this, metaData, str, str2) == null) || a() == null || metaData == null) {
            return;
        }
        this.r = metaData.getUserIdLong();
        this.p = metaData.getUserName();
        this.q = metaData.getName_show();
        this.m = str;
        this.s = str2;
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            boolean h2 = vt4.k().h("key_post_thread_has_request_location", false);
            if (this.v || this.g == null || bm8.a().d() || !this.g.G(this.n.getPageActivity()) || !TbadkCoreApplication.getInst().getLocationShared() || !h2) {
                return;
            }
            this.g.K();
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.g.B()) {
                if (this.g.F()) {
                    this.F.b(bm8.a().b());
                    return;
                }
                if (oi.C()) {
                    this.g.K();
                }
                b0(0, true, null);
                return;
            }
            b0(0, false, null);
        }
    }

    public void R() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (editorTools = this.D) == null) {
            return;
        }
        editorTools.y();
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.h.setWriteData(null);
            this.h.i0(false);
            this.e = null;
            this.u = null;
            this.b.clear();
        }
    }

    public void T() {
        n25 n25Var;
        TextWatcher textWatcher;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (n25Var = this.B) == null || (textWatcher = this.A) == null) {
            return;
        }
        n25Var.i(textWatcher);
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            WriteData b0 = this.h.b0();
            if (b0 == null) {
                b0 = new WriteData(1);
                b0.setThreadId(str);
                b0.setWriteImagesInfo(this.b);
            }
            b0.setContent(this.c);
            b0.setVideoInfo(this.u);
            b0.setVoiceModel(this.e);
            fk8.y(str, b0);
        }
    }

    public final void V(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, arrayList) == null) || a() == null) {
            return;
        }
        a().A(new i05(17, 27, arrayList));
    }

    public void W(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || a() == null) {
            return;
        }
        a().A(new i05(44, 27, str));
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || a() == null) {
            return;
        }
        a().A(new i05(13, -1, null));
    }

    public final void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || a() == null) {
            return;
        }
        if (z) {
            a().A(new i05(2, 10, null));
            a().A(new i05(2, 6, null));
        }
        a().A(new i05(9, -1, Boolean.valueOf(z)));
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || StringUtils.isNull(this.p)) {
            return;
        }
        long j = this.r;
        if (j <= 0) {
            return;
        }
        if (String.valueOf(j).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
            oi.M(this.n.getPageActivity(), R.string.obfuscated_res_0x7f0f036b);
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.n.getPageActivity(), this.r, this.p, this.q, GiftTabActivityConfig.FROM_PB, mg.g(this.m, 0L), mg.g(this.s, 0L))));
    }

    public final void a0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, str) == null) || a() == null) {
            return;
        }
        a().A(new i05(6, 27, str));
    }

    public final void b0(int i, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), str}) == null) {
            this.t = i;
            if (a() != null) {
                a().A(new i05(19, 27, new y15(i, z, str)));
            }
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || a() == null) {
            return;
        }
        a().A(new i05(2, 19, " "));
    }

    public void d0(j25 j25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, j25Var) == null) {
            this.y = j25Var;
        }
    }

    public void e0(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, tbPageContext) == null) {
            this.n = tbPageContext;
        }
    }

    public void f0(boolean z) {
        BLauncher bLauncher;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048607, this, z) == null) || a() == null || (bLauncher = (BLauncher) a().m(5)) == null) {
            return;
        }
        bLauncher.setOutSetVisibilty(z);
    }

    public void g0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.C = i;
        }
    }

    public TbPageContext getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.n : (TbPageContext) invokeV.objValue;
    }

    public void h(zw4 zw4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, zw4Var) == null) || zw4Var == null) {
            return;
        }
        if (zw4Var.getType() == EmotionGroupType.BIG_EMOTION || zw4Var.getType() == EmotionGroupType.USER_COLLECT) {
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setImageType(1);
            imageFileInfo.setFilePath(zw4Var.c());
            imageFileInfo.width = zw4Var.g();
            imageFileInfo.height = zw4Var.b();
            this.b.addChooseFile(imageFileInfo);
            this.b.updateQuality();
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.z = z;
        }
    }

    public void i(TextWatcher textWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, textWatcher) == null) {
            k();
            n25 n25Var = this.B;
            if (n25Var == null || textWatcher == null) {
                return;
            }
            n25Var.f(textWatcher);
        }
    }

    public void i0(boolean z) {
        BLauncher bLauncher;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048613, this, z) == null) || a() == null || (bLauncher = (BLauncher) a().m(23)) == null) {
            return;
        }
        bLauncher.setOutSetVisibilty(z);
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            if (this.B == null && a() != null) {
                this.B = (n25) a().n(27);
            }
            n25 n25Var = this.B;
            if (n25Var != null) {
                n25Var.g(i);
            }
        }
    }

    public void j0(DataModel<?> dataModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, dataModel) == null) {
            this.j = dataModel;
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && this.B == null && a() != null) {
            this.B = (n25) a().n(27);
        }
    }

    public void k0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            if (this.B == null && a() != null) {
                this.B = (n25) a().n(27);
            }
            n25 n25Var = this.B;
            if (n25Var != null) {
                n25Var.k(str);
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            WriteImagesInfo writeImagesInfo = this.b;
            if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
                this.b.clear();
            }
            VideoInfo videoInfo = this.u;
            if (videoInfo != null && videoInfo.isAvaliable()) {
                this.u = null;
            }
            a().A(new i05(2, 19, null));
            t0(null);
            a().A(new i05(2, 6, null));
            a().A(new i05(33, 6, null));
            if (!StringUtils.isNull(this.c)) {
                this.c = "";
            }
            a0("");
            this.h.setWriteData(null);
            this.h.i0(false);
        }
    }

    public void l0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            if (this.B == null && a() != null) {
                this.B = (n25) a().n(27);
            }
            n25 n25Var = this.B;
            if (n25Var != null) {
                n25Var.l(i);
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.u = null;
        }
    }

    public void m0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.c = str;
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            new g(this).execute(new Void[0]);
        }
    }

    public void n0(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, gVar) == null) {
            this.w = gVar;
        }
    }

    public final void o() {
        DataModel<?> dataModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048624, this) == null) || this.l == null || (dataModel = this.j) == null || !dataModel.H()) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_COMMENT);
        statisticItem.addParam("obj_locate", 1);
        if (this.l.isVideoWorksInfo()) {
            statisticItem.addParam("obj_type", 3);
        } else if (this.l.isVideoThreadType()) {
            statisticItem.addParam("obj_type", 2);
        } else {
            statisticItem.addParam("obj_type", 1);
        }
        statisticItem.addParam("tid", this.l.getTid());
        statisticItem.addParam(TiebaStatic.Params.FID_1, this.l.getFid());
        statisticItem.addParam(TiebaStatic.Params.FID_2, this.j.getFromForumId());
        statisticItem.addParam("order_id", this.j.D());
        TiebaStatic.log(statisticItem);
        sk4.a(sk4.f, sk4.c, this.j.D(), this.j.E(), this.j.C(), this.l.statFloor);
    }

    public void o0(k25 k25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, k25Var) == null) {
            this.x = k25Var;
        }
    }

    @Override // com.repackage.fk8.f
    public void onDraftLoaded(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, writeData) == null) || writeData == null) {
            return;
        }
        if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
            if (this.u == null) {
                this.u = new VideoInfo();
            }
            this.u.copy(writeData.getVideoInfo());
            c0();
            a().A(new i05(39, -1, this.u));
        }
        if (writeData.getWriteImagesInfo() != null && this.b.size() == 0) {
            this.b.copyFrom(writeData.getWriteImagesInfo());
            WriteImagesInfo writeImagesInfo = this.b;
            if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && this.b.getChosedFiles().size() > 0) {
                EditorTools a2 = a();
                a2.A(new i05(2, 10, this.b.getChosedFiles().size() + ""));
            }
        }
        WriteImagesInfo writeImagesInfo2 = this.b;
        if (writeImagesInfo2 == null || writeImagesInfo2.size() == 0) {
            a().A(new i05(2, 10, null));
        }
        if (writeData.getVoiceModel() != null && writeData.getVoiceModel().voiceId != null && writeData.getVoiceModel().duration != -1) {
            if (this.e == null) {
                this.e = new VoiceData.VoiceModel();
            }
            this.e.copy(writeData.getVoiceModel());
        }
        if (!ni.isEmpty(writeData.getContent()) && ni.isEmpty(this.c)) {
            String content = writeData.getContent();
            this.c = content;
            a0(content);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
    }

    public void p(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, writeData) == null) || writeData == null) {
            return;
        }
        int i = 0;
        if (!TextUtils.isEmpty(writeData.getContent())) {
            int i2 = 0;
            while (TbPatternsCompat.EMOTION_PATTERRN.matcher(writeData.getContent()).find()) {
                i2++;
            }
            if (i2 > 0 && this.C > 0) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMALL_EMOTION_NUM);
                statisticItem.param("obj_type", i2);
                statisticItem.param("obj_source", this.C);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", writeData.getThreadId());
                TiebaStatic.log(statisticItem);
            }
        }
        if (writeData.getWriteImagesInfo() == null || ListUtils.isEmpty(writeData.getWriteImagesInfo().getChosedFiles())) {
            return;
        }
        for (ImageFileInfo imageFileInfo : writeData.getWriteImagesInfo().getChosedFiles()) {
            if (imageFileInfo.getImageType() == 1) {
                i++;
            }
        }
        if (i <= 0 || this.C <= 0) {
            return;
        }
        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_BIG_EMOTION_NUM);
        statisticItem2.param("obj_type", i);
        statisticItem2.param("obj_source", this.C);
        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem2.param("tid", writeData.getThreadId());
        TiebaStatic.log(statisticItem2);
    }

    public void p0(boolean z) {
        BLauncher bLauncher;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048628, this, z) == null) || a() == null || (bLauncher = (BLauncher) a().m(2)) == null) {
            return;
        }
        bLauncher.setOutSetVisibilty(z);
    }

    public final void q(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, intent) == null) {
            w(intent, true);
        }
    }

    public void q0(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, spanGroupManager) == null) {
            this.d = spanGroupManager;
        }
    }

    public final void r(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, intent) == null) {
            this.f = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
            String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.f;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, oi.d(this.n.getPageActivity(), oi.k(this.n.getPageActivity())), oi.d(this.n.getPageActivity(), oi.i(this.n.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    FileHelper.saveBitmapByRelativelyPath(TbConfig.LOCAL_CAMERA_DIR, this.f, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception unused) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.b.addChooseFile(imageFileInfo);
            this.b.updateQuality();
            z(false, null);
        }
    }

    public void r0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, threadData) == null) {
            this.l = threadData;
            if (a() == null || this.l == null) {
                return;
            }
            a().setFid(this.l.getFid());
            a().setTid(this.l.getTid());
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
            fk8.o(str, this);
        }
    }

    public void s0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            this.m = str;
        }
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.t : invokeV.intValue;
    }

    public void t0(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, voiceModel) == null) {
            this.e = voiceModel;
        }
    }

    public final void u(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, intent) == null) {
            w(intent, false);
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            cr4 cr4Var = new cr4(this.n.getPageActivity());
            cr4Var.setMessageId(R.string.obfuscated_res_0x7f0f0a40).setPositiveButton(R.string.obfuscated_res_0x7f0f0964, new e(this)).setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new d(this)).create(this.n);
            cr4Var.show();
        }
    }

    public n25 v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            if (this.B == null && a() != null) {
                this.B = (n25) a().n(27);
            }
            return this.B;
        }
        return (n25) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            if (!this.g.G(this.n.getPageActivity())) {
                this.n.showToast(R.string.obfuscated_res_0x7f0f0a47);
            } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
                u0();
            } else if (this.g.F()) {
                A();
            } else {
                this.g.P(false);
                b0(1, true, null);
                this.g.K();
            }
        }
    }

    public final void w(Intent intent, boolean z) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048641, this, intent, z) == null) || intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        this.b.parseJson(stringExtra);
        this.b.updateQuality();
        if (this.b.getChosedFiles() != null) {
            z(false, null);
        }
    }

    public SpanGroupManager x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.d : (SpanGroupManager) invokeV.objValue;
    }

    public WriteImagesInfo y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.b : (WriteImagesInfo) invokeV.objValue;
    }

    public void z(boolean z, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048644, this, z, postWriteCallBackData) == null) {
            PbEditorData pbEditorData = new PbEditorData();
            pbEditorData.setEditorType(0);
            pbEditorData.setContent(this.c);
            pbEditorData.setWriteImagesInfo(this.b);
            pbEditorData.setVoiceModel(this.e);
            PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
            ForumData forumData = this.k;
            if (forumData != null) {
                threadData.setForumId(forumData.getId());
                threadData.setForumName(this.k.getName());
                threadData.setFirstDir(this.k.getFirst_class());
                threadData.setSecondDir(this.k.getSecond_class());
            }
            threadData.setAuthorId(this.r);
            threadData.setAuthorName(this.p);
            threadData.setAuthorNameShow(this.q);
            threadData.setPostId(this.s);
            threadData.setThreadId(this.m);
            threadData.isBJH = this.v;
            pbEditorData.setThreadData(threadData);
            pbEditorData.setDisableVoiceMessage(this.o);
            pbEditorData.setOpenVoiceRecordButton(z);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.n.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
        }
    }
}
