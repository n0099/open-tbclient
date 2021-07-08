package d.a.o0.w.w;

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
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
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
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.o0.r.q.b2;
import d.a.o0.r.s.a;
import d.a.o0.s.c.i0;
import d.a.o0.s.c.v;
import d.a.p0.h3.y;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class e extends d.a.o0.w.e implements y.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NewWriteModel.g A;
    public d.a.o0.w.w.c B;
    public d.a.o0.w.w.b C;
    public boolean D;
    public TextWatcher E;
    public d.a.o0.w.w.f F;
    public int G;
    public EditorTools H;
    public boolean I;
    public LocationModel.e J;
    public LocationModel.f K;
    public final NewWriteModel.g L;
    public final d.a.c.a.e M;

    /* renamed from: f  reason: collision with root package name */
    public WriteImagesInfo f53542f;

    /* renamed from: g  reason: collision with root package name */
    public String f53543g;

    /* renamed from: h  reason: collision with root package name */
    public SpanGroupManager f53544h;

    /* renamed from: i  reason: collision with root package name */
    public VoiceData$VoiceModel f53545i;
    public String j;
    public LocationModel k;
    public NewWriteModel l;
    public ImageModel m;
    public DataModel<?> n;
    public ForumData o;
    public b2 p;
    public String q;
    public TbPageContext r;
    public String s;
    public String t;
    public String u;
    public long v;
    public String w;
    public int x;
    public VideoInfo y;
    public boolean z;

    /* loaded from: classes7.dex */
    public class a implements LocationModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f53546a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53546a = eVar;
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53546a.r.showToast(R.string.no_network_guide);
                this.f53546a.b0(0, false, null);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void b(LocationData locationData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locationData) == null) {
                if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                    this.f53546a.b0(2, true, locationData.getFormatted_address());
                } else {
                    onFail(null);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (this.f53546a.I) {
                    TbPageContext tbPageContext = this.f53546a.r;
                    if (StringUtils.isNull(str)) {
                        str = this.f53546a.a().getContext().getString(R.string.location_fail);
                    }
                    tbPageContext.showToast(str);
                }
                this.f53546a.b0(0, false, null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements LocationModel.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f53547a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53547a = eVar;
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53547a.b0(0, false, null);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.f
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f53547a.b0(2, true, str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f53548e;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53548e = eVar;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f53548e.b0(0, true, null);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f53549e;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53549e = eVar;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (d.a.c.e.p.j.z()) {
                    this.f53549e.b0(1, true, null);
                    this.f53549e.k.K();
                } else {
                    this.f53549e.J.a();
                }
                aVar.dismiss();
            }
        }
    }

    /* renamed from: d.a.o0.w.w.e$e  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1240e implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f53550a;

        public C1240e(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53550a = eVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, i0 i0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, i0Var, writeData, antiData}) == null) {
                if (writeData == null) {
                    writeData = this.f53550a.l.X();
                }
                if (z) {
                    this.f53550a.Y(true);
                    WriteData X = this.f53550a.l.X();
                    this.f53550a.S();
                    y.s(this.f53550a.q, null);
                    if (X == null) {
                        return;
                    }
                    if (X.getType() == 2) {
                        y.k(X.getThreadId(), this.f53550a);
                    }
                } else if (writeData != null && i0Var != null && !TextUtils.isEmpty(i0Var.d())) {
                    writeData.setVcodeMD5(i0Var.b());
                    writeData.setVcodeUrl(i0Var.c());
                    writeData.setVcodeExtra(i0Var.a());
                    if (this.f53550a.p != null) {
                        writeData.setBaijiahaoData(this.f53550a.p.J());
                    }
                    if (d.a.o0.a1.a.b(i0Var.d())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.f53550a.r.getPageActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData, false, i0Var.d())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.f53550a.r.getPageActivity(), writeData, CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE)));
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.f53550a.r.getPageActivity(), CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, writeData, postWriteCallBackData.getAccessState())));
                }
                e eVar = this.f53550a;
                eVar.G(eVar.l.X());
                NewWriteModel.g gVar = this.f53550a.A;
                if (gVar != null) {
                    gVar.callback(z, postWriteCallBackData, i0Var, writeData, antiData);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends BdAsyncTask<Void, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f53551a;

        public f(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53551a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                FileHelper.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + this.f53551a.j));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g extends d.a.c.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f53552a;

        public g(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53552a = eVar;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof Bitmap)) {
                this.f53552a.l.d0(true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(EditorTools editorTools) {
        super(editorTools);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {editorTools};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((EditorTools) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53542f = new WriteImagesInfo();
        this.f53543g = "";
        this.l = null;
        this.m = null;
        this.q = null;
        this.s = null;
        this.x = 0;
        this.D = false;
        this.G = 0;
        this.I = true;
        this.J = new a(this);
        this.K = new b(this);
        this.L = new C1240e(this);
        this.M = new g(this);
        this.H = editorTools;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.r.getPageActivity())));
        }
    }

    public boolean B() {
        InterceptResult invokeV;
        LinkedList<ImageFileInfo> chosedFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            WriteImagesInfo writeImagesInfo = this.f53542f;
            return (writeImagesInfo == null || (chosedFiles = writeImagesInfo.getChosedFiles()) == null || chosedFiles.isEmpty()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (StringUtils.isNull(this.f53543g)) {
                WriteImagesInfo writeImagesInfo = this.f53542f;
                if (writeImagesInfo == null || writeImagesInfo.size() <= 0) {
                    VoiceData$VoiceModel voiceData$VoiceModel = this.f53545i;
                    if (voiceData$VoiceModel == null || StringUtils.isNull(voiceData$VoiceModel.getId())) {
                        VideoInfo videoInfo = this.y;
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
            VoiceData$VoiceModel voiceData$VoiceModel = this.f53545i;
            return (voiceData$VoiceModel == null || TextUtils.isEmpty(voiceData$VoiceModel.voiceId) || this.f53545i.duration <= 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.I = false;
        }
    }

    public void F(TbPageContext tbPageContext, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, tbPageContext, bundle) == null) {
            NewWriteModel newWriteModel = new NewWriteModel(tbPageContext);
            this.l = newWriteModel;
            newWriteModel.h0(this.L);
            ImageModel imageModel = new ImageModel(tbPageContext);
            this.m = imageModel;
            imageModel.setLoadDataCallBack(this.M);
            LocationModel locationModel = new LocationModel(tbPageContext);
            this.k = locationModel;
            locationModel.N(this.J);
            this.k.O(this.K);
            if (bundle != null) {
                this.f53542f.parseJson(bundle.getString("write_images"));
                this.j = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            WriteImagesInfo writeImagesInfo = this.f53542f;
            if (writeImagesInfo != null) {
                writeImagesInfo.setMaxImagesAllowed(this.z ? 1 : 9);
            }
            if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && a() != null) {
                a().A(new d.a.o0.w.a(2, 12, " "));
            }
            if (!this.k.z() && a() != null) {
                a().A(new d.a.o0.w.a(20, 8, null));
            }
            WriteImagesInfo writeImagesInfo2 = this.f53542f;
            if (writeImagesInfo2 == null || writeImagesInfo2.getChosedFiles() == null || this.f53542f.getChosedFiles().size() <= 0) {
                return;
            }
            EditorTools a2 = a();
            a2.A(new d.a.o0.w.a(2, 10, this.f53542f.getChosedFiles().size() + ""));
        }
    }

    public void G(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, writeData) == null) || writeData == null) {
            return;
        }
        this.f53542f = new WriteImagesInfo();
        if (writeData.getWriteImagesInfo() != null) {
            this.f53542f.copyFrom(writeData.getWriteImagesInfo());
            WriteImagesInfo writeImagesInfo = this.f53542f;
            if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && this.f53542f.getChosedFiles().size() > 0) {
                EditorTools a2 = a();
                a2.A(new d.a.o0.w.a(2, 10, this.f53542f.getChosedFiles().size() + ""));
            }
        }
        WriteImagesInfo writeImagesInfo2 = this.f53542f;
        if (writeImagesInfo2 == null || writeImagesInfo2.size() == 0) {
            a().A(new d.a.o0.w.a(2, 10, null));
        }
        String content = writeData.getContent();
        this.f53543g = content;
        a0(content);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
    }

    public void H(int i2, int i3, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i2, i3, intent) == null) {
            PostWriteCallBackData postWriteCallBackData = null;
            if (i3 != -1) {
                if (i2 == 12001) {
                    n();
                } else if (i2 == 12002) {
                    if (intent == null || !intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        return;
                    }
                    this.f53542f.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                } else if (i2 != 12006) {
                } else {
                    if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    }
                    PostWriteCallBackData postWriteCallBackData2 = postWriteCallBackData;
                    NewWriteModel.g gVar = this.A;
                    if (gVar != null) {
                        gVar.callback(false, postWriteCallBackData2, null, this.l.X(), null);
                    }
                }
            } else if (i2 == 11001) {
                L(null, null);
            } else if (i2 == 12006) {
                WriteData X = this.l.X();
                PostWriteCallBackData postWriteCallBackData3 = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                if (X != null) {
                    X.deleteUploadedTempImages();
                }
                this.l.setWriteData(null);
                this.l.d0(false);
                this.f53545i = null;
                this.y = null;
                if (!TextUtils.isEmpty(this.q)) {
                    y.s(this.q, null);
                }
                Y(true);
                NewWriteModel.g gVar2 = this.A;
                if (gVar2 != null) {
                    gVar2.callback(true, postWriteCallBackData3, null, X, null);
                }
            } else if (i2 == 12012) {
                u(intent);
            } else if (i2 == 13010) {
                if (a() == null) {
                    return;
                }
                VideoInfo videoInfo = new VideoInfo();
                videoInfo.parseFromIntent(intent);
                if (videoInfo.isAvaliable()) {
                    this.y = videoInfo;
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.XIAOYING_DURATION);
                    statisticItem.param("duration", this.y.getVideoDuration());
                    TiebaStatic.log(statisticItem);
                    c0();
                    a().A(new d.a.o0.w.a(28, 20, this.y));
                    a().A(new d.a.o0.w.a(28, -1, this.y));
                }
            } else if (i2 == 23004) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
            } else if (i2 == 25004) {
                if (intent != null) {
                    W(intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING));
                }
            } else if (i2 == 11025) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.r.getPageActivity(), 12004, true)));
            } else if (i2 == 11026) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.r.getPageActivity(), CyberPlayerManager.MEDIA_INFO_WEAK_NETWORK_BEST_RANK, true)));
            } else if (i2 == 12009 || i2 == 12010) {
                if (i2 == 12010) {
                    q(intent);
                }
            } else {
                switch (i2) {
                    case 12002:
                        if (intent == null) {
                            return;
                        }
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            q(intent);
                        } else {
                            p(intent);
                        }
                        a().invalidate();
                        return;
                    case 12003:
                        if (intent == null) {
                            return;
                        }
                        if (intent.getBooleanExtra("delete", false)) {
                            X();
                            this.l.d0(false);
                            return;
                        }
                        this.m.B(intent.getStringExtra("file_name"));
                        return;
                    case 12004:
                        if (intent == null || (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) == null) {
                            return;
                        }
                        V(stringArrayListExtra);
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
            this.l.cancelLoadData();
            this.m.cancelLoadData();
            this.k.cancelLoadData();
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (!PermissionUtil.checkLocationForGoogle(this.r.getPageActivity())) {
                PermissionUtil.reuqestLocation(this.r.getPageActivity(), 0);
            } else {
                v0();
            }
        }
    }

    public void K(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            WriteImagesInfo writeImagesInfo = this.f53542f;
            if (writeImagesInfo != null) {
                bundle.putString("write_images", writeImagesInfo.toJsonString());
            }
            bundle.putString(WriteActivityConfig.PHOTO_NAME, this.j);
        }
    }

    public void L(String str, WriteData writeData) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, writeData) == null) {
            if (this.l.X() == null) {
                WriteData x = this.n.x(str);
                if (x != null && (b2Var = this.p) != null) {
                    x.setBaijiahaoData(b2Var.J());
                }
                this.l.setWriteData(x);
            }
            if (this.l.X() == null) {
                return;
            }
            this.l.setSpanGroupManager(this.f53544h);
            boolean z = true;
            if (this.D) {
                this.l.X().setCanNoForum(true);
                if (this.o != null) {
                    this.l.X().setVForumId(this.o.getId());
                    this.l.X().setVForumName(this.o.getName());
                }
            } else {
                this.l.X().setCanNoForum(false);
                this.l.X().setVForumId("");
                this.l.X().setVForumName("");
            }
            this.l.X().setIsBJHPost(this.z);
            this.l.X().setWriteImagesInfo(this.f53542f);
            this.l.X().setVideoInfo(this.y);
            this.l.d0(this.f53542f.size() > 0);
            WriteData X = this.l.X();
            LocationModel locationModel = this.k;
            X.setHasLocationData((locationModel == null || !locationModel.z()) ? false : false);
            if (str == null) {
                this.l.X().setContent(this.f53543g);
            }
            VoiceData$VoiceModel voiceData$VoiceModel = this.f53545i;
            if (voiceData$VoiceModel != null) {
                if (voiceData$VoiceModel.getId() != null) {
                    this.l.X().setVoice(this.f53545i.getId());
                    this.l.X().setVoiceDuringTime(this.f53545i.duration);
                } else {
                    this.l.X().setVoice(null);
                    this.l.X().setVoiceDuringTime(-1);
                }
            } else {
                this.l.X().setVoice(null);
                this.l.X().setVoiceDuringTime(-1);
            }
            if (!this.l.U()) {
                this.r.showToast(R.string.write_img_limit);
                return;
            }
            d.a.o0.w.w.b bVar = this.C;
            if (bVar == null || !bVar.a()) {
                d.a.o0.w.w.c cVar = this.B;
                if (cVar != null) {
                    cVar.a();
                }
                o(this.l.X());
                if (!this.l.l0()) {
                }
            }
        }
    }

    public void M(AntiData antiData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, antiData) == null) || antiData == null) {
            return;
        }
        this.s = antiData.getVoice_message();
    }

    public void N(ForumData forumData, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, forumData, userData) == null) {
            this.o = forumData;
        }
    }

    public void O(MetaData metaData, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048590, this, metaData, str, str2) == null) || a() == null || metaData == null) {
            return;
        }
        this.v = metaData.getUserIdLong();
        this.t = metaData.getUserName();
        this.u = metaData.getName_show();
        this.q = str;
        this.w = str2;
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.z || this.k == null || d.a.p0.h3.m0.b.a().d() || !UtilHelper.isSystemLocationProviderEnabled(this.r.getPageActivity()) || !TbadkCoreApplication.getInst().getLocationShared()) {
            return;
        }
        this.k.H();
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.k.z()) {
                if (this.k.D()) {
                    this.J.b(d.a.p0.h3.m0.b.a().b());
                    return;
                }
                if (l.D()) {
                    this.k.H();
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
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (editorTools = this.H) == null) {
            return;
        }
        editorTools.y();
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.l.setWriteData(null);
            this.l.d0(false);
            this.f53545i = null;
            this.y = null;
            this.f53542f.clear();
        }
    }

    public void T() {
        d.a.o0.w.w.f fVar;
        TextWatcher textWatcher;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (fVar = this.F) == null || (textWatcher = this.E) == null) {
            return;
        }
        fVar.j(textWatcher);
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            WriteData X = this.l.X();
            if (X == null) {
                X = new WriteData(1);
                X.setThreadId(str);
                X.setWriteImagesInfo(this.f53542f);
            }
            X.setContent(this.f53543g);
            X.setVideoInfo(this.y);
            X.setVoiceModel(this.f53545i);
            y.s(str, X);
        }
    }

    public final void V(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, arrayList) == null) || a() == null) {
            return;
        }
        a().A(new d.a.o0.w.a(17, 27, arrayList));
    }

    public void W(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || a() == null) {
            return;
        }
        a().A(new d.a.o0.w.a(44, 27, str));
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || a() == null) {
            return;
        }
        a().A(new d.a.o0.w.a(13, -1, null));
    }

    public final void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || a() == null) {
            return;
        }
        if (z) {
            a().A(new d.a.o0.w.a(2, 10, null));
            a().A(new d.a.o0.w.a(2, 6, null));
        }
        a().A(new d.a.o0.w.a(9, -1, Boolean.valueOf(z)));
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || StringUtils.isNull(this.t)) {
            return;
        }
        long j = this.v;
        if (j <= 0) {
            return;
        }
        if (String.valueOf(j).equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
            l.L(this.r.getPageActivity(), R.string.can_not_send_gift_to_yourself);
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.r.getPageActivity(), this.v, this.t, this.u, GiftTabActivityConfig.FROM_PB, d.a.c.e.m.b.f(this.q, 0L), d.a.c.e.m.b.f(this.w, 0L))));
    }

    public final void a0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, str) == null) || a() == null) {
            return;
        }
        a().A(new d.a.o0.w.a(6, 27, str));
    }

    public final void b0(int i2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str}) == null) {
            this.x = i2;
            if (a() != null) {
                a().A(new d.a.o0.w.a(19, 27, new d.a.o0.w.u.a(i2, z, str)));
            }
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || a() == null) {
            return;
        }
        a().A(new d.a.o0.w.a(2, 19, " "));
    }

    public void d0(d.a.o0.w.w.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bVar) == null) {
            this.C = bVar;
        }
    }

    public void e0(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, tbPageContext) == null) {
            this.r = tbPageContext;
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

    public void g0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.G = i2;
        }
    }

    public void h(v vVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, vVar) == null) || vVar == null) {
            return;
        }
        if (vVar.f() == EmotionGroupType.BIG_EMOTION || vVar.f() == EmotionGroupType.USER_COLLECT) {
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setImageType(1);
            imageFileInfo.setFilePath(vVar.c());
            imageFileInfo.width = vVar.h();
            imageFileInfo.height = vVar.b();
            this.f53542f.addChooseFile(imageFileInfo);
            this.f53542f.updateQuality();
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.D = z;
        }
    }

    public void i(TextWatcher textWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, textWatcher) == null) {
            k();
            d.a.o0.w.w.f fVar = this.F;
            if (fVar == null || textWatcher == null) {
                return;
            }
            fVar.g(textWatcher);
        }
    }

    public void i0(boolean z) {
        BLauncher bLauncher;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048612, this, z) == null) || a() == null || (bLauncher = (BLauncher) a().m(23)) == null) {
            return;
        }
        bLauncher.setOutSetVisibilty(z);
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            if (this.F == null && a() != null) {
                this.F = (d.a.o0.w.w.f) a().n(27);
            }
            d.a.o0.w.w.f fVar = this.F;
            if (fVar != null) {
                fVar.h(i2);
            }
        }
    }

    public void j0(DataModel<?> dataModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, dataModel) == null) {
            this.n = dataModel;
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && this.F == null && a() != null) {
            this.F = (d.a.o0.w.w.f) a().n(27);
        }
    }

    public void k0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            if (this.F == null && a() != null) {
                this.F = (d.a.o0.w.w.f) a().n(27);
            }
            d.a.o0.w.w.f fVar = this.F;
            if (fVar != null) {
                fVar.l(str);
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            WriteImagesInfo writeImagesInfo = this.f53542f;
            if (writeImagesInfo != null && writeImagesInfo.size() > 0) {
                this.f53542f.clear();
            }
            VideoInfo videoInfo = this.y;
            if (videoInfo != null && videoInfo.isAvaliable()) {
                this.y = null;
            }
            a().A(new d.a.o0.w.a(2, 19, null));
            t0(null);
            a().A(new d.a.o0.w.a(2, 6, null));
            a().A(new d.a.o0.w.a(33, 6, null));
            if (!StringUtils.isNull(this.f53543g)) {
                this.f53543g = "";
            }
            a0("");
            this.l.setWriteData(null);
            this.l.d0(false);
        }
    }

    public void l0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            if (this.F == null && a() != null) {
                this.F = (d.a.o0.w.w.f) a().n(27);
            }
            d.a.o0.w.w.f fVar = this.F;
            if (fVar != null) {
                fVar.m(i2);
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.y = null;
        }
    }

    public void m0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.f53543g = str;
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            new f(this).execute(new Void[0]);
        }
    }

    public void n0(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, gVar) == null) {
            this.A = gVar;
        }
    }

    public void o(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, writeData) == null) || writeData == null) {
            return;
        }
        int i2 = 0;
        if (!TextUtils.isEmpty(writeData.getContent())) {
            int i3 = 0;
            while (TbPatternsCompat.EMOTION_PATTERRN.matcher(writeData.getContent()).find()) {
                i3++;
            }
            if (i3 > 0 && this.G > 0) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMALL_EMOTION_NUM);
                statisticItem.param("obj_type", i3);
                statisticItem.param("obj_source", this.G);
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
                i2++;
            }
        }
        if (i2 <= 0 || this.G <= 0) {
            return;
        }
        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_BIG_EMOTION_NUM);
        statisticItem2.param("obj_type", i2);
        statisticItem2.param("obj_source", this.G);
        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem2.param("tid", writeData.getThreadId());
        TiebaStatic.log(statisticItem2);
    }

    public void o0(d.a.o0.w.w.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, cVar) == null) {
            this.B = cVar;
        }
    }

    @Override // d.a.p0.h3.y.e
    public void onDraftLoaded(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, writeData) == null) || writeData == null) {
            return;
        }
        if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
            if (this.y == null) {
                this.y = new VideoInfo();
            }
            this.y.copy(writeData.getVideoInfo());
            c0();
            a().A(new d.a.o0.w.a(39, -1, this.y));
        }
        if (writeData.getWriteImagesInfo() != null && this.f53542f.size() == 0) {
            this.f53542f.copyFrom(writeData.getWriteImagesInfo());
            WriteImagesInfo writeImagesInfo = this.f53542f;
            if (writeImagesInfo != null && writeImagesInfo.getChosedFiles() != null && this.f53542f.getChosedFiles().size() > 0) {
                EditorTools a2 = a();
                a2.A(new d.a.o0.w.a(2, 10, this.f53542f.getChosedFiles().size() + ""));
            }
        }
        WriteImagesInfo writeImagesInfo2 = this.f53542f;
        if (writeImagesInfo2 == null || writeImagesInfo2.size() == 0) {
            a().A(new d.a.o0.w.a(2, 10, null));
        }
        if (writeData.getVoiceModel() != null && writeData.getVoiceModel().voiceId != null && writeData.getVoiceModel().duration != -1) {
            if (this.f53545i == null) {
                this.f53545i = new VoiceData$VoiceModel();
            }
            this.f53545i.copy(writeData.getVoiceModel());
        }
        if (!k.isEmpty(writeData.getContent()) && k.isEmpty(this.f53543g)) {
            String content = writeData.getContent();
            this.f53543g = content;
            a0(content);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004008));
    }

    public final void p(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, intent) == null) {
            w(intent, true);
        }
    }

    public void p0(boolean z) {
        BLauncher bLauncher;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048627, this, z) == null) || a() == null || (bLauncher = (BLauncher) a().m(2)) == null) {
            return;
        }
        bLauncher.setOutSetVisibilty(z);
    }

    public final void q(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, intent) == null) {
            this.j = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
            String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.j;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.e(this.r.getPageActivity(), l.k(this.r.getPageActivity())), l.e(this.r.getPageActivity(), l.i(this.r.getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    FileHelper.SaveFile(TbConfig.LOCAL_CAMERA_DIR, this.j, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception unused) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.f53542f.addChooseFile(imageFileInfo);
            this.f53542f.updateQuality();
            z(false, null);
        }
    }

    public void q0(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, spanGroupManager) == null) {
            this.f53544h = spanGroupManager;
        }
    }

    public TbPageContext r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.r : (TbPageContext) invokeV.objValue;
    }

    public void r0(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, b2Var) == null) {
            this.p = b2Var;
            if (a() == null || this.p == null) {
                return;
            }
            a().setFid(this.p.Q());
            a().setTid(this.p.n1());
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            y.k(str, this);
        }
    }

    public void s0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
            this.q = str;
        }
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.x : invokeV.intValue;
    }

    public void t0(VoiceData$VoiceModel voiceData$VoiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, voiceData$VoiceModel) == null) {
            this.f53545i = voiceData$VoiceModel;
        }
    }

    public final void u(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, intent) == null) {
            w(intent, false);
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(this.r.getPageActivity());
            aVar.setMessageId(R.string.location_app_permission_prompt).setPositiveButton(R.string.isopen, new d(this)).setNegativeButton(R.string.cancel, new c(this)).create(this.r);
            aVar.show();
        }
    }

    public d.a.o0.w.w.f v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if (this.F == null && a() != null) {
                this.F = (d.a.o0.w.w.f) a().n(27);
            }
            return this.F;
        }
        return (d.a.o0.w.w.f) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            if (!UtilHelper.isSystemLocationProviderEnabled(this.r.getPageActivity())) {
                this.r.showToast(R.string.location_system_permission_prompt);
            } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
                u0();
            } else if (this.k.D()) {
                A();
            } else {
                this.k.M(false);
                b0(1, true, null);
                this.k.H();
            }
        }
    }

    public final void w(Intent intent, boolean z) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048640, this, intent, z) == null) || intent == null || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        this.f53542f.parseJson(stringExtra);
        this.f53542f.updateQuality();
        if (this.f53542f.getChosedFiles() != null) {
            z(false, null);
        }
    }

    public VideoInfo x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.y : (VideoInfo) invokeV.objValue;
    }

    public WriteImagesInfo y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.f53542f : (WriteImagesInfo) invokeV.objValue;
    }

    public void z(boolean z, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048643, this, z, postWriteCallBackData) == null) {
            PbEditorData pbEditorData = new PbEditorData();
            pbEditorData.setEditorType(0);
            pbEditorData.setContent(this.f53543g);
            pbEditorData.setWriteImagesInfo(this.f53542f);
            pbEditorData.setVoiceModel(this.f53545i);
            PbEditorData.ThreadData threadData = new PbEditorData.ThreadData();
            ForumData forumData = this.o;
            if (forumData != null) {
                threadData.setForumId(forumData.getId());
                threadData.setForumName(this.o.getName());
                threadData.setFirstDir(this.o.getFirst_class());
                threadData.setSecondDir(this.o.getSecond_class());
            }
            threadData.setAuthorId(this.v);
            threadData.setAuthorName(this.t);
            threadData.setAuthorNameShow(this.u);
            threadData.setPostId(this.w);
            threadData.setThreadId(this.q);
            threadData.isBJH = this.z;
            pbEditorData.setThreadData(threadData);
            pbEditorData.setDisableVoiceMessage(this.s);
            pbEditorData.setOpenVoiceRecordButton(z);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.r.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
        }
    }
}
