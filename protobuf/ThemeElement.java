package protobuf;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class ThemeElement extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_COMMONCOLOR = "";
    public static final String DEFAULT_DARKCOLOR = "";
    public static final String DEFAULT_FONTCOLOR = "";
    public static final String DEFAULT_LIGHTCOLOR = "";
    public static final String DEFAULT_PATTERNIMAGE = "";
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String commonColor;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String darkColor;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String fontColor;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String lightColor;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String patternImage;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<ThemeElement> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String commonColor;
        public String darkColor;
        public String fontColor;
        public String lightColor;
        public String patternImage;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(ThemeElement themeElement) {
            super(themeElement);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {themeElement};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Message) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (themeElement == null) {
                return;
            }
            this.commonColor = themeElement.commonColor;
            this.darkColor = themeElement.darkColor;
            this.lightColor = themeElement.lightColor;
            this.patternImage = themeElement.patternImage;
            this.fontColor = themeElement.fontColor;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ThemeElement build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new ThemeElement(this, z, null) : (ThemeElement) invokeZ.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public /* synthetic */ ThemeElement(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThemeElement(Builder builder, boolean z) {
        super(builder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Message.Builder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (z) {
            String str = builder.commonColor;
            if (str == null) {
                this.commonColor = "";
            } else {
                this.commonColor = str;
            }
            String str2 = builder.darkColor;
            if (str2 == null) {
                this.darkColor = "";
            } else {
                this.darkColor = str2;
            }
            String str3 = builder.lightColor;
            if (str3 == null) {
                this.lightColor = "";
            } else {
                this.lightColor = str3;
            }
            String str4 = builder.patternImage;
            if (str4 == null) {
                this.patternImage = "";
            } else {
                this.patternImage = str4;
            }
            String str5 = builder.fontColor;
            if (str5 == null) {
                this.fontColor = "";
                return;
            } else {
                this.fontColor = str5;
                return;
            }
        }
        this.commonColor = builder.commonColor;
        this.darkColor = builder.darkColor;
        this.lightColor = builder.lightColor;
        this.patternImage = builder.patternImage;
        this.fontColor = builder.fontColor;
    }
}
