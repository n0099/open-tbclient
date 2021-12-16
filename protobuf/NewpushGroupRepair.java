package protobuf;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes4.dex */
public final class NewpushGroupRepair extends Message {
    public static /* synthetic */ Interceptable $ic;
    public static final Long DEFAULT_ENDSID;
    public static final Long DEFAULT_FROMUID;
    public static final Integer DEFAULT_FROMUTYPE;
    public static final Long DEFAULT_GID;
    public static final Integer DEFAULT_GTYPE;
    public static final Long DEFAULT_LASTMID;
    public static final Long DEFAULT_STARTSID;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long endSid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer fromUType;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long fromUid;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long gid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer gtype;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long lastMid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long startSid;

    /* loaded from: classes4.dex */
    public static final class Builder extends Message.Builder<NewpushGroupRepair> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Long endSid;
        public Integer fromUType;
        public Long fromUid;
        public Long gid;
        public Integer gtype;
        public Long lastMid;
        public Long startSid;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(NewpushGroupRepair newpushGroupRepair) {
            super(newpushGroupRepair);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newpushGroupRepair};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Message) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (newpushGroupRepair == null) {
                return;
            }
            this.gid = newpushGroupRepair.gid;
            this.gtype = newpushGroupRepair.gtype;
            this.startSid = newpushGroupRepair.startSid;
            this.endSid = newpushGroupRepair.endSid;
            this.lastMid = newpushGroupRepair.lastMid;
            this.fromUid = newpushGroupRepair.fromUid;
            this.fromUType = newpushGroupRepair.fromUType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public NewpushGroupRepair build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new NewpushGroupRepair(this, z, null) : (NewpushGroupRepair) invokeZ.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1805328815, "Lprotobuf/NewpushGroupRepair;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1805328815, "Lprotobuf/NewpushGroupRepair;");
                return;
            }
        }
        DEFAULT_GID = 0L;
        DEFAULT_GTYPE = 0;
        DEFAULT_STARTSID = 0L;
        DEFAULT_ENDSID = 0L;
        DEFAULT_LASTMID = 0L;
        DEFAULT_FROMUID = 0L;
        DEFAULT_FROMUTYPE = 0;
    }

    public /* synthetic */ NewpushGroupRepair(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewpushGroupRepair(Builder builder, boolean z) {
        super(builder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Message.Builder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (z) {
            Long l = builder.gid;
            if (l == null) {
                this.gid = DEFAULT_GID;
            } else {
                this.gid = l;
            }
            Integer num = builder.gtype;
            if (num == null) {
                this.gtype = DEFAULT_GTYPE;
            } else {
                this.gtype = num;
            }
            Long l2 = builder.startSid;
            if (l2 == null) {
                this.startSid = DEFAULT_STARTSID;
            } else {
                this.startSid = l2;
            }
            Long l3 = builder.endSid;
            if (l3 == null) {
                this.endSid = DEFAULT_ENDSID;
            } else {
                this.endSid = l3;
            }
            Long l4 = builder.lastMid;
            if (l4 == null) {
                this.lastMid = DEFAULT_LASTMID;
            } else {
                this.lastMid = l4;
            }
            Long l5 = builder.fromUid;
            if (l5 == null) {
                this.fromUid = DEFAULT_FROMUID;
            } else {
                this.fromUid = l5;
            }
            Integer num2 = builder.fromUType;
            if (num2 == null) {
                this.fromUType = DEFAULT_FROMUTYPE;
                return;
            } else {
                this.fromUType = num2;
                return;
            }
        }
        this.gid = builder.gid;
        this.gtype = builder.gtype;
        this.startSid = builder.startSid;
        this.endSid = builder.endSid;
        this.lastMid = builder.lastMid;
        this.fromUid = builder.fromUid;
        this.fromUType = builder.fromUType;
    }
}
