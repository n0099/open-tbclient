package d.a.s0.a4.k;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f57453a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.c.a.f f57454b;

    /* renamed from: c  reason: collision with root package name */
    public WriteImagesInfo f57455c;

    /* renamed from: d  reason: collision with root package name */
    public VideoFileInfo f57456d;

    /* renamed from: e  reason: collision with root package name */
    public String f57457e;

    /* renamed from: f  reason: collision with root package name */
    public ImageFileInfo f57458f;

    /* renamed from: g  reason: collision with root package name */
    public List<ImageFileInfo> f57459g;

    /* renamed from: h  reason: collision with root package name */
    public final List<d.a.r0.e.a> f57460h;

    public c(d.a.c.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57453a = 9;
        this.f57460h = new ArrayList();
        this.f57454b = fVar;
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (this.f57455c == null) {
                this.f57455c = new WriteImagesInfo(this.f57453a);
            }
            this.f57455c.setLastAlbumId(str);
        }
    }

    public void B(boolean z) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (writeImagesInfo = this.f57455c) == null) {
            return;
        }
        writeImagesInfo.setOriginalImg(z);
    }

    public void C(WriteImagesInfo writeImagesInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeImagesInfo) == null) {
            this.f57455c = writeImagesInfo;
        }
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WriteImagesInfo writeImagesInfo = this.f57455c;
            if (writeImagesInfo == null) {
                return 0;
            }
            return writeImagesInfo.size();
        }
        return invokeV.intValue;
    }

    public void a(ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, imageFileInfo) == null) {
            if (this.f57455c == null) {
                this.f57455c = new WriteImagesInfo(this.f57453a);
            }
            this.f57455c.addChooseFile(imageFileInfo);
        }
    }

    public void b() {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (writeImagesInfo = this.f57455c) == null) {
            return;
        }
        writeImagesInfo.clear();
    }

    public void c(ImageFileInfo imageFileInfo) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, imageFileInfo) == null) || (writeImagesInfo = this.f57455c) == null) {
            return;
        }
        writeImagesInfo.delChooseFile(imageFileInfo);
    }

    public List<MediaFileInfo> d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (this.f57460h != null && !StringUtils.isNull(str)) {
                for (d.a.r0.e.a aVar : this.f57460h) {
                    if (aVar != null && TextUtils.equals(str, aVar.b())) {
                        return aVar.d();
                    }
                }
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public List<d.a.r0.e.a> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f57460h : (List) invokeV.objValue;
    }

    public VideoFileInfo f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f57456d : (VideoFileInfo) invokeV.objValue;
    }

    public List<ImageFileInfo> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            WriteImagesInfo writeImagesInfo = this.f57455c;
            if (writeImagesInfo != null) {
                return writeImagesInfo.getChosedFiles();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f57457e : (String) invokeV.objValue;
    }

    public List<ImageFileInfo> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f57459g : (List) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        List<ImageFileInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ImageFileInfo imageFileInfo = this.f57458f;
            if (imageFileInfo != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && (list = this.f57459g) != null && list.size() != 0) {
                int size = this.f57459g.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ImageFileInfo imageFileInfo2 = this.f57459g.get(i2);
                    if (imageFileInfo2 != null && this.f57458f.getFilePath().equals(imageFileInfo2.getFilePath())) {
                        return i2;
                    }
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            WriteImagesInfo writeImagesInfo = this.f57455c;
            if (writeImagesInfo != null) {
                return writeImagesInfo.getLastAlbumId();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            WriteImagesInfo writeImagesInfo = this.f57455c;
            if (writeImagesInfo != null) {
                return writeImagesInfo.getMaxImagesAllowed();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public WriteImagesInfo m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f57455c : (WriteImagesInfo) invokeV.objValue;
    }

    public boolean n(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, imageFileInfo)) == null) {
            WriteImagesInfo writeImagesInfo = this.f57455c;
            if (writeImagesInfo == null) {
                return false;
            }
            return writeImagesInfo.isAdded(imageFileInfo);
        }
        return invokeL.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? !ListUtils.isEmpty(g()) : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f57456d != null : invokeV.booleanValue;
    }

    public boolean q(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, videoFileInfo)) == null) {
            VideoFileInfo videoFileInfo2 = this.f57456d;
            return (videoFileInfo2 == null || videoFileInfo == null || videoFileInfo2.videoId != videoFileInfo.videoId) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? ListUtils.isEmpty(d(d.a.r0.e.a.f55216f)) : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            WriteImagesInfo writeImagesInfo = this.f57455c;
            if (writeImagesInfo != null) {
                return writeImagesInfo.isOriginalImg();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public d.a.r0.e.a t(List<MediaFileInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, list)) == null) {
            d.a.r0.e.a aVar = new d.a.r0.e.a();
            aVar.h(d.a.r0.e.a.f55216f);
            aVar.l(this.f57454b.getString(R.string.album_all_media));
            int count = ListUtils.getCount(list);
            aVar.j(list);
            aVar.i(String.valueOf(count));
            MediaFileInfo mediaFileInfo = (MediaFileInfo) ListUtils.getItem(list, count - 1);
            if (mediaFileInfo instanceof ImageFileInfo) {
                aVar.k((ImageFileInfo) mediaFileInfo);
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                aVar.k((VideoFileInfo) mediaFileInfo);
            }
            return aVar;
        }
        return (d.a.r0.e.a) invokeL.objValue;
    }

    public d.a.r0.e.a u(List<VideoFileInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, list)) == null) {
            d.a.r0.e.a aVar = new d.a.r0.e.a();
            aVar.h(d.a.r0.e.a.f55217g);
            aVar.l(this.f57454b.getString(R.string.album_all_video));
            int count = ListUtils.getCount(list);
            aVar.i(String.valueOf(count));
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(list)) {
                arrayList.addAll(list);
            }
            aVar.j(arrayList);
            VideoFileInfo videoFileInfo = (VideoFileInfo) ListUtils.getItem(list, count - 1);
            if (videoFileInfo != null) {
                aVar.k(videoFileInfo);
            }
            return aVar;
        }
        return (d.a.r0.e.a) invokeL.objValue;
    }

    public final void v(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, str) == null) || this.f57460h == null || StringUtils.isNull(str)) {
            return;
        }
        for (d.a.r0.e.a aVar : this.f57460h) {
            if (aVar != null && TextUtils.equals(str, aVar.b())) {
                ArrayList arrayList = new ArrayList();
                if (aVar.d() != null) {
                    for (MediaFileInfo mediaFileInfo : aVar.d()) {
                        if (mediaFileInfo instanceof ImageFileInfo) {
                            arrayList.add((ImageFileInfo) mediaFileInfo);
                        }
                    }
                }
                this.f57459g = arrayList;
            }
        }
    }

    public void w(VideoFileInfo videoFileInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, videoFileInfo) == null) {
            this.f57456d = videoFileInfo;
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.f57457e = str;
            v(str);
        }
    }

    public void y(ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, imageFileInfo) == null) {
            this.f57458f = imageFileInfo;
        }
    }

    public void z(d.a.r0.e.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, gVar) == null) || gVar == null) {
            return;
        }
        List<MediaFileInfo> list = gVar.f55248b;
        ArrayList arrayList = new ArrayList();
        arrayList.add(t(list));
        if (!ListUtils.isEmpty(gVar.f55249c)) {
            arrayList.add(u(gVar.f55249c));
        }
        if (!ListUtils.isEmpty(gVar.f55247a)) {
            arrayList.addAll(gVar.f55247a);
        }
        this.f57460h.clear();
        this.f57460h.addAll(arrayList);
    }
}
