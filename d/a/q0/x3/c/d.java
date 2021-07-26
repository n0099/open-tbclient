package d.a.q0.x3.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.switchs.VideoMiddleAdSwitch;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.data.VideoAttentionPersonListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.t.c.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f66931a;

    /* renamed from: b  reason: collision with root package name */
    public final List<VideoItemModel> f66932b;

    /* renamed from: c  reason: collision with root package name */
    public final List<VideoAttentionPersonListData> f66933c;

    /* renamed from: d  reason: collision with root package name */
    public String f66934d;

    /* renamed from: e  reason: collision with root package name */
    public final int f66935e;

    /* renamed from: f  reason: collision with root package name */
    public final int f66936f;

    /* renamed from: g  reason: collision with root package name */
    public String f66937g;

    /* renamed from: h  reason: collision with root package name */
    public int f66938h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f66939i;
    public c j;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66938h = -1;
        this.f66939i = true;
        this.f66932b = new LinkedList();
        this.f66935e = e.g() - 1;
        this.f66936f = e.f() + 1;
        this.f66933c = new LinkedList();
    }

    public void a(int i2) {
        VideoItemModel videoItemModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() && this.f66939i) {
            ArrayList arrayList = new ArrayList(this.f66932b);
            if (this.f66938h < 0) {
                int i3 = this.f66935e;
                this.f66938h = i3;
                if (i3 <= i2) {
                    return;
                }
                if (i3 >= arrayList.size() + 1) {
                    this.f66938h = -1;
                    return;
                }
                VideoItemModel videoItemModel2 = (VideoItemModel) ListUtils.getItem(arrayList, this.f66938h);
                if (videoItemModel2 == null || !videoItemModel2.isFunAdType()) {
                    arrayList.add(this.f66938h, new VideoItemModel(null, 2));
                }
            }
            int i4 = this.f66938h;
            while (true) {
                i4 += this.f66936f;
                if (i4 >= arrayList.size() + 1) {
                    break;
                } else if (i4 > i2 && ((videoItemModel = (VideoItemModel) ListUtils.getItem(arrayList, i4)) == null || !videoItemModel.isFunAdType())) {
                    this.f66938h = i4;
                    arrayList.add(i4, new VideoItemModel(null, 2));
                }
            }
            this.f66932b.clear();
            this.f66932b.addAll(arrayList);
            c cVar = this.j;
            if (cVar != null) {
                cVar.e();
            }
        }
    }

    public void b(@NonNull List<VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (VideoItemData videoItemData : list) {
                arrayList.add(new VideoItemModel(videoItemData, 1));
            }
            this.f66932b.addAll(arrayList);
            c cVar = this.j;
            if (cVar != null) {
                cVar.e();
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f66932b.size() == 0) {
            this.f66932b.add(new VideoItemModel(null, VideoItemModel.TYPE_LOADING));
        }
    }

    public final void d() {
        VideoItemModel videoItemModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f66932b.size() <= 1 || (videoItemModel = this.f66932b.get(0)) == null || !videoItemModel.isLoadingType()) {
            return;
        }
        this.f66932b.remove(0);
    }

    public boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 < 0) {
                return false;
            }
            VideoItemModel videoItemModel = null;
            Iterator<VideoItemModel> it = this.f66932b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                VideoItemModel next = it.next();
                if (next.getHashCode() == i2) {
                    videoItemModel = next;
                    break;
                }
            }
            if (videoItemModel == null || !videoItemModel.isFunAdType()) {
                return false;
            }
            int indexOf = this.f66932b.indexOf(videoItemModel);
            int i3 = this.f66938h;
            if (indexOf < i3) {
                this.f66938h = i3 - 1;
            }
            this.f66932b.remove(videoItemModel);
            c cVar = this.j;
            if (cVar != null) {
                cVar.d();
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            VideoItemModel videoItemModel = null;
            Iterator<VideoItemModel> it = this.f66932b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                VideoItemModel next = it.next();
                if (next != null && next.getVideoItemData() != null && str.equalsIgnoreCase(next.getVideoItemData().thread_id)) {
                    videoItemModel = next;
                    break;
                }
            }
            if (videoItemModel != null) {
                this.f66932b.remove(videoItemModel);
                c cVar = this.j;
                if (cVar != null) {
                    cVar.d();
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            for (int i3 = i2 + 1; i3 < this.f66932b.size(); i3++) {
                VideoItemModel videoItemModel = (VideoItemModel) ListUtils.getItem(this.f66932b, i3);
                if (videoItemModel != null && videoItemModel.isFunAdType()) {
                    this.f66932b.remove(videoItemModel);
                    return true;
                }
            }
            if (this.f66938h + this.f66936f > this.f66932b.size() - 1) {
                this.f66938h += this.f66936f;
                return false;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public List<VideoItemModel> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f66932b : (List) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f66932b.size() : invokeV.intValue;
    }

    public VideoItemModel j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? (VideoItemModel) ListUtils.getItem(this.f66932b, i2) : (VideoItemModel) invokeI.objValue;
    }

    public BdUniqueId k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f66931a : (BdUniqueId) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f66937g : (String) invokeV.objValue;
    }

    public List<VideoAttentionPersonListData> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f66933c : (List) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f66934d : (String) invokeV.objValue;
    }

    @Nullable
    public VideoItemData o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            VideoItemModel videoItemModel = (VideoItemModel) ListUtils.getItem(this.f66932b, i2);
            if (videoItemModel == null) {
                return null;
            }
            return videoItemModel.getVideoItemData();
        }
        return (VideoItemData) invokeI.objValue;
    }

    public boolean p(VideoItemModel videoItemModel, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, videoItemModel, i2)) == null) {
            if (i2 == 0 && this.f66932b.size() > 0 && this.f66932b.get(0).isLoadingType()) {
                this.f66932b.set(0, videoItemModel);
                c cVar = this.j;
                if (cVar != null) {
                    cVar.e();
                }
                return true;
            }
            if (i2 < this.f66932b.size()) {
                this.f66932b.add(i2, videoItemModel);
            } else {
                this.f66932b.add(videoItemModel);
            }
            d();
            c cVar2 = this.j;
            if (cVar2 != null) {
                cVar2.e();
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? ListUtils.isEmpty(this.f66932b) : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f66932b.size() == 0 || (this.f66932b.size() == 1 && this.f66932b.get(0).isLoadingType()) : invokeV.booleanValue;
    }

    public boolean s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            int i3 = this.f66935e;
            while (i3 < this.f66932b.size()) {
                if (i3 == i2) {
                    return true;
                }
                i3 += this.f66936f;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void t(List<VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, list) == null) || list == null) {
            return;
        }
        this.f66938h = -1;
        List arrayList = new ArrayList(this.f66932b);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= arrayList.size()) {
                break;
            }
            if (((VideoItemModel) ListUtils.getItem(arrayList, i2)).isFunAdType()) {
                this.f66938h = i2;
            } else {
                int i4 = i3 + 1;
                VideoItemData videoItemData = (VideoItemData) ListUtils.getItem(list, i3);
                if (videoItemData == null) {
                    arrayList = arrayList.subList(0, i2);
                    i3 = i4;
                    break;
                }
                arrayList.set(i2, new VideoItemModel(videoItemData, 1));
                i3 = i4;
            }
            i2++;
        }
        if (i3 < list.size()) {
            for (VideoItemData videoItemData2 : list.subList(i3, list.size())) {
                arrayList.add(new VideoItemModel(videoItemData2, 1));
            }
        }
        this.f66932b.clear();
        this.f66932b.addAll(arrayList);
        d();
        this.f66939i = true;
        c cVar = this.j;
        if (cVar != null) {
            cVar.b();
        }
    }

    public void u(List<VideoAttentionPersonListData> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, list, str) == null) {
            this.f66932b.clear();
            this.f66932b.add(new VideoItemModel(null, 4));
            this.f66933c.clear();
            this.f66933c.addAll(list);
            this.f66934d = str;
            this.f66939i = false;
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f66932b.clear();
            this.f66932b.add(new VideoItemModel(null, 3));
            this.f66939i = false;
        }
    }

    public void w(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            this.f66931a = bdUniqueId;
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.f66937g = str;
        }
    }

    public void y(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, cVar) == null) {
            this.j = cVar;
        }
    }
}
