package com.google.zxing.client.result;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class AddressBookParsedResult extends ParsedResult {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String[] addressTypes;
    public final String[] addresses;
    public final String birthday;
    public final String[] emailTypes;
    public final String[] emails;
    public final String[] geo;
    public final String instantMessenger;
    public final String[] names;
    public final String[] nicknames;
    public final String note;

    /* renamed from: org  reason: collision with root package name */
    public final String f55153org;
    public final String[] phoneNumbers;
    public final String[] phoneTypes;
    public final String pronunciation;
    public final String title;
    public final String[] urls;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AddressBookParsedResult(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String[] strArr7) {
        this(strArr, null, null, strArr2, strArr3, strArr4, strArr5, null, null, strArr6, strArr7, null, null, null, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {strArr, strArr2, strArr3, strArr4, strArr5, strArr6, strArr7};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String[]) objArr2[0], (String[]) objArr2[1], (String) objArr2[2], (String[]) objArr2[3], (String[]) objArr2[4], (String[]) objArr2[5], (String[]) objArr2[6], (String) objArr2[7], (String) objArr2[8], (String[]) objArr2[9], (String[]) objArr2[10], (String) objArr2[11], (String) objArr2[12], (String) objArr2[13], (String[]) objArr2[14], (String[]) objArr2[15]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public String[] getAddressTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.addressTypes : (String[]) invokeV.objValue;
    }

    public String[] getAddresses() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.addresses : (String[]) invokeV.objValue;
    }

    public String getBirthday() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.birthday : (String) invokeV.objValue;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            StringBuilder sb = new StringBuilder(100);
            ParsedResult.maybeAppend(this.names, sb);
            ParsedResult.maybeAppend(this.nicknames, sb);
            ParsedResult.maybeAppend(this.pronunciation, sb);
            ParsedResult.maybeAppend(this.title, sb);
            ParsedResult.maybeAppend(this.f55153org, sb);
            ParsedResult.maybeAppend(this.addresses, sb);
            ParsedResult.maybeAppend(this.phoneNumbers, sb);
            ParsedResult.maybeAppend(this.emails, sb);
            ParsedResult.maybeAppend(this.instantMessenger, sb);
            ParsedResult.maybeAppend(this.urls, sb);
            ParsedResult.maybeAppend(this.birthday, sb);
            ParsedResult.maybeAppend(this.geo, sb);
            ParsedResult.maybeAppend(this.note, sb);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String[] getEmailTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.emailTypes : (String[]) invokeV.objValue;
    }

    public String[] getEmails() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.emails : (String[]) invokeV.objValue;
    }

    public String[] getGeo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.geo : (String[]) invokeV.objValue;
    }

    public String getInstantMessenger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.instantMessenger : (String) invokeV.objValue;
    }

    public String[] getNames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.names : (String[]) invokeV.objValue;
    }

    public String[] getNicknames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.nicknames : (String[]) invokeV.objValue;
    }

    public String getNote() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.note : (String) invokeV.objValue;
    }

    public String getOrg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f55153org : (String) invokeV.objValue;
    }

    public String[] getPhoneNumbers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.phoneNumbers : (String[]) invokeV.objValue;
    }

    public String[] getPhoneTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.phoneTypes : (String[]) invokeV.objValue;
    }

    public String getPronunciation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.pronunciation : (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.title : (String) invokeV.objValue;
    }

    public String[] getURLs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.urls : (String[]) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddressBookParsedResult(String[] strArr, String[] strArr2, String str, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String str2, String str3, String[] strArr7, String[] strArr8, String str4, String str5, String str6, String[] strArr9, String[] strArr10) {
        super(ParsedResultType.ADDRESSBOOK);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strArr, strArr2, str, strArr3, strArr4, strArr5, strArr6, str2, str3, strArr7, strArr8, str4, str5, str6, strArr9, strArr10};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((ParsedResultType) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.names = strArr;
        this.nicknames = strArr2;
        this.pronunciation = str;
        this.phoneNumbers = strArr3;
        this.phoneTypes = strArr4;
        this.emails = strArr5;
        this.emailTypes = strArr6;
        this.instantMessenger = str2;
        this.note = str3;
        this.addresses = strArr7;
        this.addressTypes = strArr8;
        this.f55153org = str4;
        this.birthday = str5;
        this.title = str6;
        this.urls = strArr9;
        this.geo = strArr10;
    }
}
