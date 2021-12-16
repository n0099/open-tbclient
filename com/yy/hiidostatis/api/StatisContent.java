package com.yy.hiidostatis.api;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.BaseStatisContent;
import com.yy.hiidostatis.inner.util.StringUtil;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class StatisContent extends BaseStatisContent {
    public static /* synthetic */ Interceptable $ic;
    public static AtomicInteger TMP_START_ID;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean fillCommon;
    public boolean fillConcrete;
    public boolean isCover;
    public String mAct;
    public long mAutoId;
    public int mCrepid;
    public String mGuid;
    public boolean notSave;
    public Priority priority;
    public int tmpId;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class Priority {
        public static final /* synthetic */ Priority[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Priority PRIORITY_HIGH;
        public static final Priority PRIORITY_LOW;
        public static final Priority PRIORITY_NORMAL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2135480966, "Lcom/yy/hiidostatis/api/StatisContent$Priority;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2135480966, "Lcom/yy/hiidostatis/api/StatisContent$Priority;");
                    return;
                }
            }
            PRIORITY_HIGH = new Priority("PRIORITY_HIGH", 0);
            PRIORITY_NORMAL = new Priority("PRIORITY_NORMAL", 1);
            Priority priority = new Priority("PRIORITY_LOW", 2);
            PRIORITY_LOW = priority;
            $VALUES = new Priority[]{PRIORITY_HIGH, PRIORITY_NORMAL, priority};
        }

        public Priority(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Priority valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Priority) Enum.valueOf(Priority.class, str) : (Priority) invokeL.objValue;
        }

        public static Priority[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Priority[]) $VALUES.clone() : (Priority[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1889897560, "Lcom/yy/hiidostatis/api/StatisContent;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1889897560, "Lcom/yy/hiidostatis/api/StatisContent;");
                return;
            }
        }
        TMP_START_ID = new AtomicInteger(0);
    }

    public StatisContent() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.fillCommon = true;
        this.fillConcrete = true;
        this.isCover = true;
        this.notSave = false;
        this.priority = Priority.PRIORITY_NORMAL;
        this.tmpId = TMP_START_ID.incrementAndGet();
        setGuid(createGuid());
    }

    public static String createGuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? StringUtil.geneGuid() : (String) invokeV.objValue;
    }

    public StatisContent copyByNewGuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StatisContent statisContent = new StatisContent();
            TreeMap<String, String> treeMap = new TreeMap<>(BaseStatisContent.COMPARATOR);
            statisContent.raw = treeMap;
            treeMap.putAll(this.raw);
            statisContent.setAct(this.mAct);
            statisContent.setAutoId(this.mAutoId);
            statisContent.setCover(this.isCover);
            statisContent.setCrepid(this.mCrepid);
            statisContent.setFillCommon(this.fillCommon);
            statisContent.setFillConcrete(this.fillConcrete);
            statisContent.setNotSave(this.notSave);
            statisContent.setPriority(this.priority);
            return statisContent;
        }
        return (StatisContent) invokeV.objValue;
    }

    public String getAct() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAct : (String) invokeV.objValue;
    }

    public long getAutoId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mAutoId : invokeV.longValue;
    }

    public int getCrepid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mCrepid : invokeV.intValue;
    }

    public String getGuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mGuid : (String) invokeV.objValue;
    }

    public Priority getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.priority : (Priority) invokeV.objValue;
    }

    public int getTmpId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.tmpId : invokeV.intValue;
    }

    public boolean isCover() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.isCover : invokeV.booleanValue;
    }

    public boolean isFillCommon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.fillCommon : invokeV.booleanValue;
    }

    public boolean isFillConcrete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.fillConcrete : invokeV.booleanValue;
    }

    public boolean isNotSave() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.notSave : invokeV.booleanValue;
    }

    public void putContent(StatisContent statisContent, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, statisContent, z) == null) {
            super.putContent((BaseStatisContent) statisContent, z);
        }
    }

    public void setAct(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.mAct = str;
        }
    }

    public void setAutoId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j2) == null) {
            this.mAutoId = j2;
        }
    }

    public void setCover(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.isCover = z;
        }
    }

    public void setCrepid(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.mCrepid = i2;
        }
    }

    public void setFillCommon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.fillCommon = z;
        }
    }

    public void setFillConcrete(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.fillConcrete = z;
        }
    }

    public void setGuid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.mGuid = str;
            put(BaseStatisContent.GUID, str);
        }
    }

    public void setNotSave(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.notSave = z;
        }
    }

    public void setPriority(Priority priority) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, priority) == null) {
            this.priority = priority;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.yy.hiidostatis.inner.BaseStatisContent
    public StatisContent copy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StatisContent statisContent = new StatisContent();
            TreeMap<String, String> treeMap = new TreeMap<>(BaseStatisContent.COMPARATOR);
            statisContent.raw = treeMap;
            treeMap.putAll(this.raw);
            statisContent.setAct(this.mAct);
            statisContent.setAutoId(this.mAutoId);
            statisContent.setCover(this.isCover);
            statisContent.setCrepid(this.mCrepid);
            statisContent.setFillCommon(this.fillCommon);
            statisContent.setFillConcrete(this.fillConcrete);
            statisContent.setNotSave(this.notSave);
            statisContent.setPriority(this.priority);
            statisContent.setGuid(this.mGuid);
            return statisContent;
        }
        return (StatisContent) invokeV.objValue;
    }

    public StatisContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.fillCommon = true;
        this.fillConcrete = true;
        this.isCover = true;
        this.notSave = false;
        this.priority = Priority.PRIORITY_NORMAL;
        this.tmpId = TMP_START_ID.incrementAndGet();
        this.mAct = str;
        setGuid(createGuid());
    }
}
