package d.a.q0.a4.u;

import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.tieba.write.write.WriteImageGridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a4.u.h;
/* loaded from: classes7.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<WriteActivity> f54964a;

    /* renamed from: b  reason: collision with root package name */
    public WriteImageGridView f54965b;

    /* renamed from: c  reason: collision with root package name */
    public WriteImagesInfo f54966c;

    /* renamed from: d  reason: collision with root package name */
    public h f54967d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.p0.c0.b f54968e;

    /* renamed from: f  reason: collision with root package name */
    public String f54969f;

    /* renamed from: g  reason: collision with root package name */
    public String f54970g;

    /* renamed from: h  reason: collision with root package name */
    public h.f f54971h;

    /* loaded from: classes7.dex */
    public class a implements h.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f54972a;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54972a = iVar;
        }

        @Override // d.a.q0.a4.u.h.f
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f54972a.f54966c == null || this.f54972a.f54966c.getChosedFiles() == null || i2 < 0 || i2 >= this.f54972a.f54966c.getChosedFiles().size()) {
                return;
            }
            ImageFileInfo remove = this.f54972a.f54966c.getChosedFiles().remove(i2);
            if (remove.isTempFile()) {
                d.a.d.e.a.d.g().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            i iVar = this.f54972a;
            iVar.f54967d.f(iVar.f54966c);
            this.f54972a.f54967d.notifyDataSetChanged();
            if (ListUtils.isEmpty(this.f54972a.f54966c.getChosedFiles()) && this.f54972a.f54964a.getOrignalPage() != null) {
                ((WriteActivity) this.f54972a.f54964a.getOrignalPage()).refreshPostButton();
            }
            if (this.f54972a.f54964a.getPageActivity() instanceof WriteActivity) {
                ((WriteActivity) this.f54972a.f54964a.getPageActivity()).refreshImageLauncher();
                ((WriteActivity) this.f54972a.f54964a.getPageActivity()).refreshVideoLauncher();
            }
        }

        @Override // d.a.q0.a4.u.h.f
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f54972a.f54966c == null) {
                return;
            }
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.f54972a.f54964a.getPageActivity(), this.f54972a.f54966c.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.f54972a.f54970g);
            albumFloatActivityConfig.getIntent().putExtra("from", this.f54972a.f54969f);
            albumFloatActivityConfig.setRequestCode(12002);
            if (this.f54972a.f54964a.getPageActivity() instanceof WriteActivity) {
                albumFloatActivityConfig.setCanSelectVideo(false);
                albumFloatActivityConfig.setCanSelectOnlyVideo(false);
                albumFloatActivityConfig.setCanEditImage(false);
                AntiData antiData = new AntiData();
                antiData.voice_message = ((WriteActivity) this.f54972a.f54964a.getPageActivity()).mDisableAudioMessage;
                antiData.setIfVoice(((WriteActivity) this.f54972a.f54964a.getPageActivity()).isVoiceEnable);
                albumFloatActivityConfig.setStatisticFrom(((WriteActivity) this.f54972a.f54964a.getPageActivity()).mData.getStatisticFrom());
                albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) this.f54972a.f54964a.getPageActivity()).mPrefixData, ((WriteActivity) this.f54972a.f54964a.getPageActivity()).mData.getFirstDir(), ((WriteActivity) this.f54972a.f54964a.getPageActivity()).mData.getSecondDir());
            }
            albumFloatActivityConfig.setFromWrite(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }

        @Override // d.a.q0.a4.u.h.f
        public void c(int i2) {
            int count;
            ImageFileInfo imageInfoAt;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f54972a.f54966c == null || (count = ListUtils.getCount(this.f54972a.f54966c.getChosedFiles())) == 0 || i2 < 0 || i2 >= count || (imageInfoAt = this.f54972a.f54966c.getImageInfoAt(i2)) == null || imageInfoAt.getImageType() == 1) {
                return;
            }
            this.f54972a.f54964a.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f54972a.f54964a.getPageActivity(), 12012, this.f54972a.f54966c, i2)));
        }
    }

    public i(TbPageContext<WriteActivity> tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54968e = new d.a.p0.c0.b();
        this.f54969f = AlbumActivityConfig.FROM_WRITE;
        this.f54970g = "";
        this.f54971h = new a(this);
        this.f54964a = tbPageContext;
        this.f54965b = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        h hVar = new h(view.getContext(), this.f54968e, null, this.f54971h);
        this.f54967d = hVar;
        this.f54965b.setAdapter((ListAdapter) hVar);
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f54968e.b();
        }
    }

    public GridView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f54965b : (GridView) invokeV.objValue;
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f54967d.g(z);
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f54967d.h(z);
        }
    }

    public void i(WriteImagesInfo writeImagesInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, writeImagesInfo, str, str2) == null) {
            this.f54969f = str;
            this.f54970g = str2;
            this.f54966c = writeImagesInfo;
            this.f54967d.f(writeImagesInfo);
            this.f54967d.notifyDataSetChanged();
        }
    }
}
