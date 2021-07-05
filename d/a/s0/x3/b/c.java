package d.a.s0.x3.b;

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
import d.a.r0.s.c.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f69463a;

    /* renamed from: b  reason: collision with root package name */
    public final List<VideoItemModel> f69464b;

    /* renamed from: c  reason: collision with root package name */
    public final List<VideoAttentionPersonListData> f69465c;

    /* renamed from: d  reason: collision with root package name */
    public String f69466d;

    /* renamed from: e  reason: collision with root package name */
    public final int f69467e;

    /* renamed from: f  reason: collision with root package name */
    public final int f69468f;

    /* renamed from: g  reason: collision with root package name */
    public String f69469g;

    /* renamed from: h  reason: collision with root package name */
    public int f69470h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f69471i;

    public c() {
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
        this.f69470h = -1;
        this.f69471i = true;
        this.f69464b = new LinkedList();
        this.f69467e = e.g() - 1;
        this.f69468f = e.f() + 1;
        this.f69465c = new LinkedList();
    }

    public void a(int i2) {
        VideoItemModel videoItemModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && VideoMiddleAdSwitch.isOn() && this.f69471i) {
            ArrayList arrayList = new ArrayList(this.f69464b);
            int i3 = this.f69470h;
            if (i3 < 0) {
                i3 = this.f69467e;
            }
            this.f69470h = i3;
            while (i3 < arrayList.size() + 1) {
                if (i3 > i2 && ((videoItemModel = (VideoItemModel) ListUtils.getItem(arrayList, i3)) == null || !videoItemModel.isFunAdType())) {
                    this.f69470h = i3;
                    arrayList.add(i3, new VideoItemModel(null, 2));
                }
                i3 += this.f69468f;
            }
            this.f69464b.clear();
            this.f69464b.addAll(arrayList);
        }
    }

    public void b(@NonNull List<VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (VideoItemData videoItemData : list) {
                arrayList.add(new VideoItemModel(videoItemData, 1));
            }
            this.f69464b.addAll(arrayList);
        }
    }

    public boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (i2 < 0) {
                return false;
            }
            VideoItemModel videoItemModel = null;
            Iterator<VideoItemModel> it = this.f69464b.iterator();
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
            int indexOf = this.f69464b.indexOf(videoItemModel);
            int i3 = this.f69470h;
            if (indexOf < i3) {
                this.f69470h = i3 - 1;
            }
            this.f69464b.remove(videoItemModel);
            return true;
        }
        return invokeI.booleanValue;
    }

    public List<VideoItemModel> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f69464b : (List) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f69464b.size() : invokeV.intValue;
    }

    public VideoItemModel f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? (VideoItemModel) ListUtils.getItem(this.f69464b, i2) : (VideoItemModel) invokeI.objValue;
    }

    public BdUniqueId g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f69463a : (BdUniqueId) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f69469g : (String) invokeV.objValue;
    }

    public List<VideoAttentionPersonListData> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f69465c : (List) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f69466d : (String) invokeV.objValue;
    }

    @Nullable
    public VideoItemData k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            VideoItemModel videoItemModel = (VideoItemModel) ListUtils.getItem(this.f69464b, i2);
            if (videoItemModel == null) {
                return null;
            }
            return videoItemModel.getVideoItemData();
        }
        return (VideoItemData) invokeI.objValue;
    }

    public boolean l(VideoItemModel videoItemModel, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, videoItemModel, i2)) == null) {
            if (i2 < this.f69464b.size()) {
                this.f69464b.add(i2, videoItemModel);
                return true;
            }
            this.f69464b.add(videoItemModel);
            return true;
        }
        return invokeLI.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? ListUtils.isEmpty(this.f69464b) : invokeV.booleanValue;
    }

    public boolean n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            int i3 = this.f69467e;
            while (i3 < this.f69464b.size()) {
                if (i3 == i2) {
                    return true;
                }
                i3 += this.f69468f;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void o(List<VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, list) == null) || list == null) {
            return;
        }
        this.f69470h = -1;
        List arrayList = new ArrayList(this.f69464b);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= arrayList.size()) {
                break;
            }
            if (((VideoItemModel) ListUtils.getItem(arrayList, i2)).isFunAdType()) {
                this.f69470h = i2;
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
        this.f69464b.clear();
        this.f69464b.addAll(arrayList);
        this.f69471i = true;
    }

    public void p(List<VideoAttentionPersonListData> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, list, str) == null) {
            this.f69464b.clear();
            this.f69464b.add(new VideoItemModel(null, 4));
            this.f69465c.clear();
            this.f69465c.addAll(list);
            this.f69466d = str;
            this.f69471i = false;
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f69464b.clear();
            this.f69464b.add(new VideoItemModel(null, 3));
            this.f69471i = false;
        }
    }

    public void r(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            this.f69463a = bdUniqueId;
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.f69469g = str;
        }
    }
}
