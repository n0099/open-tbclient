package d.a.r0.r.q;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public abstract class a extends BaseCardInfo implements d.a.r0.b.f.l {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BIG_IMG = 2;
    public static final int CONTENT = 1;
    public static final int HEAD_IMG = 4;
    public static final int HEAD_VIDEO = 5;
    public static final int USER_NAME = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<String> feedBackReasonMap;
    public int floorPosition;
    public Map<BdUniqueId, d.a.r0.b.e> mABTestMap;
    public int objType;

    public a() {
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
        this.objType = 1;
        this.floorPosition = -1;
        this.mABTestMap = new HashMap();
        this.feedBackReasonMap = null;
    }

    private d.a.r0.b.e getCurUsbAbTestSwitchByKey(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return null;
            }
            return this.mABTestMap.get(bdUniqueId);
        }
        return (d.a.r0.b.e) invokeL.objValue;
    }

    public abstract w0 getNegFeedBackData();

    public String getPbInputLocate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String getRecomReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (getThreadData() == null) {
                return null;
            }
            return getThreadData().getRecomReason();
        }
        return (String) invokeV.objValue;
    }

    public abstract b2 getThreadData();

    public boolean isFromFrs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            b2 threadData = getThreadData();
            if (threadData == null) {
                return false;
            }
            return threadData.isFromFrs();
        }
        return invokeV.booleanValue;
    }

    public boolean isSelf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ThreadCardUtils.isSelf(getThreadData()) : invokeV.booleanValue;
    }

    @Override // d.a.r0.b.f.l
    public void setABTest(BdUniqueId bdUniqueId, d.a.r0.b.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, bdUniqueId, eVar) == null) || bdUniqueId == null) {
            return;
        }
        this.mABTestMap.put(bdUniqueId, eVar);
    }

    public boolean showCardBottomOpWeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            b2 threadData = getThreadData();
            if (threadData == null) {
                return false;
            }
            return threadData.W1 || threadData.X1 || threadData.a2 || threadData.Y1 || threadData.b2 || threadData.Z1;
        }
        return invokeV.booleanValue;
    }

    public boolean showCardEnterFourm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            b2 threadData = getThreadData();
            if (threadData == null) {
                return false;
            }
            return threadData.X1 || threadData.a2 || threadData.u2();
        }
        return invokeV.booleanValue;
    }

    public boolean showCardGoodsFourm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            b2 threadData = getThreadData();
            if (threadData == null) {
                return false;
            }
            return threadData.X1 || threadData.a2 || threadData.W1;
        }
        return invokeV.booleanValue;
    }

    public boolean showFollowBtn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            b2 threadData = getThreadData();
            if (threadData == null || threadData.H() == null || ThreadCardUtils.isSelf(threadData)) {
                return false;
            }
            boolean z = threadData.J1() || threadData.E1() || threadData.H1();
            if ((!threadData.W1 || (!z && !threadData.u2())) && ((!threadData.Y1 || (!z && !threadData.u2())) && (!threadData.isFromFrs() || (!z && !threadData.u2())))) {
                if (!threadData.Z1) {
                    return false;
                }
                if (!z && !threadData.u2()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean showNewPicCut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? d.a.r0.b.d.e(getCurUsbAbTestSwitchByKey(d.a.r0.b.f.i.f54767c), "11_7_index_b") : invokeV.booleanValue;
    }

    public boolean showNewUI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? d.a.r0.b.d.e(getCurUsbAbTestSwitchByKey(d.a.r0.b.f.i.f54767c), "11_7_index_a") : invokeV.booleanValue;
    }

    public boolean showNoName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean showNoReadState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? d.a.r0.b.d.e(getCurUsbAbTestSwitchByKey(d.a.r0.b.f.i.f54767c), "11_7_index_e") : invokeV.booleanValue;
    }

    public boolean showWeakenName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
