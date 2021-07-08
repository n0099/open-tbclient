package d.a.p0.a4.u;

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
import d.a.p0.a4.u.h;
/* loaded from: classes7.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<WriteActivity> f54420a;

    /* renamed from: b  reason: collision with root package name */
    public WriteImageGridView f54421b;

    /* renamed from: c  reason: collision with root package name */
    public WriteImagesInfo f54422c;

    /* renamed from: d  reason: collision with root package name */
    public h f54423d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.b0.b f54424e;

    /* renamed from: f  reason: collision with root package name */
    public String f54425f;

    /* renamed from: g  reason: collision with root package name */
    public String f54426g;

    /* renamed from: h  reason: collision with root package name */
    public h.f f54427h;

    /* loaded from: classes7.dex */
    public class a implements h.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f54428a;

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
            this.f54428a = iVar;
        }

        @Override // d.a.p0.a4.u.h.f
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f54428a.f54422c == null || this.f54428a.f54422c.getChosedFiles() == null || i2 < 0 || i2 >= this.f54428a.f54422c.getChosedFiles().size()) {
                return;
            }
            ImageFileInfo remove = this.f54428a.f54422c.getChosedFiles().remove(i2);
            if (remove.isTempFile()) {
                d.a.c.e.a.d.g().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            i iVar = this.f54428a;
            iVar.f54423d.f(iVar.f54422c);
            this.f54428a.f54423d.notifyDataSetChanged();
            if (ListUtils.isEmpty(this.f54428a.f54422c.getChosedFiles()) && this.f54428a.f54420a.getOrignalPage() != null) {
                ((WriteActivity) this.f54428a.f54420a.getOrignalPage()).refreshPostButton();
            }
            if (this.f54428a.f54420a.getPageActivity() instanceof WriteActivity) {
                ((WriteActivity) this.f54428a.f54420a.getPageActivity()).refreshImageLauncher();
                ((WriteActivity) this.f54428a.f54420a.getPageActivity()).refreshVideoLauncher();
            }
        }

        @Override // d.a.p0.a4.u.h.f
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f54428a.f54422c == null) {
                return;
            }
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.f54428a.f54420a.getPageActivity(), this.f54428a.f54422c.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.f54428a.f54426g);
            albumFloatActivityConfig.getIntent().putExtra("from", this.f54428a.f54425f);
            albumFloatActivityConfig.setRequestCode(12002);
            if (this.f54428a.f54420a.getPageActivity() instanceof WriteActivity) {
                albumFloatActivityConfig.setCanSelectVideo(false);
                albumFloatActivityConfig.setCanSelectOnlyVideo(false);
                albumFloatActivityConfig.setCanEditImage(false);
                AntiData antiData = new AntiData();
                antiData.voice_message = ((WriteActivity) this.f54428a.f54420a.getPageActivity()).mDisableAudioMessage;
                antiData.setIfVoice(((WriteActivity) this.f54428a.f54420a.getPageActivity()).isVoiceEnable);
                albumFloatActivityConfig.setStatisticFrom(((WriteActivity) this.f54428a.f54420a.getPageActivity()).mData.getStatisticFrom());
                albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) this.f54428a.f54420a.getPageActivity()).mPrefixData, ((WriteActivity) this.f54428a.f54420a.getPageActivity()).mData.getFirstDir(), ((WriteActivity) this.f54428a.f54420a.getPageActivity()).mData.getSecondDir());
            }
            albumFloatActivityConfig.setFromWrite(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }

        @Override // d.a.p0.a4.u.h.f
        public void c(int i2) {
            int count;
            ImageFileInfo imageInfoAt;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f54428a.f54422c == null || (count = ListUtils.getCount(this.f54428a.f54422c.getChosedFiles())) == 0 || i2 < 0 || i2 >= count || (imageInfoAt = this.f54428a.f54422c.getImageInfoAt(i2)) == null || imageInfoAt.getImageType() == 1) {
                return;
            }
            this.f54428a.f54420a.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.f54428a.f54420a.getPageActivity(), 12012, this.f54428a.f54422c, i2)));
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
        this.f54424e = new d.a.o0.b0.b();
        this.f54425f = AlbumActivityConfig.FROM_WRITE;
        this.f54426g = "";
        this.f54427h = new a(this);
        this.f54420a = tbPageContext;
        this.f54421b = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        h hVar = new h(view.getContext(), this.f54424e, null, this.f54427h);
        this.f54423d = hVar;
        this.f54421b.setAdapter((ListAdapter) hVar);
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f54424e.b();
        }
    }

    public GridView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f54421b : (GridView) invokeV.objValue;
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f54423d.g(z);
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f54423d.h(z);
        }
    }

    public void i(WriteImagesInfo writeImagesInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, writeImagesInfo, str, str2) == null) {
            this.f54425f = str;
            this.f54426g = str2;
            this.f54422c = writeImagesInfo;
            this.f54423d.f(writeImagesInfo);
            this.f54423d.notifyDataSetChanged();
        }
    }
}
