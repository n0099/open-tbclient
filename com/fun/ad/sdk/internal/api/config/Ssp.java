package com.fun.ad.sdk.internal.api.config;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.up9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.NumberUtils;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class Ssp extends up9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<Pid> pids;
    public final String sspId;
    public final String type;

    /* loaded from: classes7.dex */
    public static class Pid extends up9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final double basePrice;
        public final int height;
        public final long id;
        public final int interval;
        public final boolean isBidding;
        public final boolean isHorizontal;
        public final String pid;
        public final float sample;
        public final Ssp ssp;
        public final int tmout;
        public final String type;
        public final int width;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Pid(int i, ObjectInput objectInput, Ssp ssp) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), objectInput, ssp};
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
            this.ssp = ssp;
            this.id = objectInput.readLong();
            this.pid = objectInput.readUTF();
            this.type = objectInput.readUTF();
            this.tmout = objectInput.readInt();
            this.sample = objectInput.readFloat();
            this.width = objectInput.readInt();
            this.height = objectInput.readInt();
            this.interval = objectInput.readInt();
            if (i == 0) {
                objectInput.readInt();
                objectInput.readInt();
            }
            this.isHorizontal = objectInput.readBoolean();
            this.basePrice = i >= 2 ? objectInput.readDouble() : 0.0d;
            this.isBidding = objectInput.readBoolean();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Pid(JSONObject jSONObject, Ssp ssp) {
            super(2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject, ssp};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.ssp = ssp;
            this.id = NumberUtils.adjustLong(jSONObject.getLong("id"), 0L);
            this.pid = jSONObject.getString("pid");
            this.type = jSONObject.getString("type");
            this.tmout = jSONObject.getInt("tmout");
            this.sample = NumberUtils.adjustFloat((float) jSONObject.optDouble("sample", 0.0d), 0.0f, 1.0f);
            this.isBidding = jSONObject.optBoolean("isBidding", false);
            this.width = NumberUtils.adjustInt(jSONObject.optInt("width", 0), 0);
            this.height = NumberUtils.adjustInt(jSONObject.optInt("height", 0), 0);
            this.interval = NumberUtils.adjustInt(jSONObject.optInt("interval", 30), 30);
            int optInt = jSONObject.optInt("orientation", 0);
            if (optInt != 0 && optInt != 1) {
                optInt = 0;
            }
            this.isHorizontal = optInt == 1;
            this.basePrice = NumberUtils.adjustDouble(jSONObject.optDouble("basePrice", 0.0d), 0.0d);
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Pid.class != obj.getClass()) {
                    return false;
                }
                Pid pid = (Pid) obj;
                return this.id == pid.id && this.tmout == pid.tmout && Float.compare(pid.sample, this.sample) == 0 && this.width == pid.width && this.height == pid.height && this.interval == pid.interval && this.isHorizontal == pid.isHorizontal && Objects.equals(this.pid, pid.pid) && Objects.equals(this.type, pid.type);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Objects.hash(Long.valueOf(this.id), this.pid, this.type, Integer.valueOf(this.tmout), Float.valueOf(this.sample), Integer.valueOf(this.width), Integer.valueOf(this.height), Integer.valueOf(this.interval), Boolean.valueOf(this.isHorizontal)) : invokeV.intValue;
        }

        @Override // com.baidu.tieba.up9
        public void srzableInternal(ObjectOutput objectOutput) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objectOutput) == null) {
                objectOutput.writeLong(this.id);
                objectOutput.writeUTF(this.pid);
                objectOutput.writeUTF(this.type);
                objectOutput.writeInt(this.tmout);
                objectOutput.writeFloat(this.sample);
                objectOutput.writeInt(this.width);
                objectOutput.writeInt(this.height);
                objectOutput.writeInt(this.interval);
                objectOutput.writeBoolean(this.isHorizontal);
                objectOutput.writeDouble(this.basePrice);
                objectOutput.writeBoolean(this.isBidding);
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return "Pid{id=" + this.id + ", pid='" + this.pid + "', type='" + this.type + "', tmout='" + this.tmout + "', sample='" + this.sample + "', width='" + this.width + "', height='" + this.height + "', interval='" + this.interval + "', isHorizontal='" + this.isHorizontal + "'}";
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ssp(int i, ObjectInput objectInput) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), objectInput};
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
        this.sspId = objectInput.readUTF();
        this.type = objectInput.readUTF();
        int readInt = objectInput.readInt();
        HashSet hashSet = new HashSet();
        for (int i4 = 0; i4 < readInt; i4++) {
            hashSet.add(new Pid(objectInput.readInt(), objectInput, this));
        }
        this.pids = Collections.unmodifiableSet(hashSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ssp(JSONObject jSONObject) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.sspId = jSONObject.getString("sspId");
        this.type = jSONObject.getString("type");
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray(TiebaStatic.Params.PID_MERGE);
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            hashSet.add(new Pid(jSONArray.getJSONObject(i3), this));
        }
        this.pids = Collections.unmodifiableSet(hashSet);
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Ssp.class != obj.getClass()) {
                return false;
            }
            Ssp ssp = (Ssp) obj;
            return Objects.equals(this.sspId, ssp.sspId) && Objects.equals(this.type, ssp.type) && Objects.equals(this.pids, ssp.pids);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Objects.hash(this.sspId, this.type, this.pids) : invokeV.intValue;
    }

    @Override // com.baidu.tieba.up9
    public void srzableInternal(ObjectOutput objectOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objectOutput) == null) {
            objectOutput.writeUTF(this.sspId);
            objectOutput.writeUTF(this.type);
            objectOutput.writeInt(this.pids.size());
            for (Pid pid : this.pids) {
                pid.srzable(objectOutput);
            }
        }
    }
}
