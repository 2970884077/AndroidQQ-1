package androidqq;

import java.util.Random;

public class Packages {
	public static void buildLoginMessage(QQUser qq)
	{
		qq.time=System.currentTimeMillis();
		qq.shareKey = Utils.hexstr2bytes("957C3AAFBF6FAF1D2C2F19A5EA04E51C");
		qq.pub_key = Utils.hexstr2bytes("02244B79F2239755E73C73FF583D4EC5625C19BF8095446DE1");
		new Random().nextBytes(qq.TGTKey);
		//qq.time = Xbin.Flip (ȡ�ֽڼ���� (���ֽڼ� (Other.TimeStamp ()), 4))
		new Random().nextBytes(qq.randKey);
		//������� (��TGTKey ��, �ֽڼ���ʮ�������ı� (qq.TGTKey))
		//������� (��randKey ��, �ֽڼ���ʮ�������ı� (qq.randKey))
		ByteBuilder bbBuilder=new ByteBuilder();
		bbBuilder.writebytes("00 09");
		bbBuilder.writeshort((short) 19);  // 00 13 //����tlv����
		bbBuilder.writebytes (Tlvs.tlv18 (qq));
		bbBuilder.writebytes (Tlvs.tlv1 (qq));
		bbBuilder.writebytes (Tlvs.tlv106 (qq));
		bbBuilder.writebytes (Tlvs.tlv116 ());
		bbBuilder.writebytes (Tlvs.tlv100 (QQGlobal.appId));
		bbBuilder.writebytes (Tlvs.tlv107 ());
		bbBuilder.writebytes (Tlvs.tlv108 (qq.ksid));
		byte tlv109[] = Tlvs.tlv109 (QQGlobal.imei_);
		byte tlv124[] = Tlvs.tlv124 (QQGlobal.os_type, QQGlobal.os_version, QQGlobal._network_type, QQGlobal._apn)
		byte tlv128[] = Tlvs.tlv128 (QQGlobal.device, QQGlobal.imei_);
		byte tlv16e[] = Tlvs.tlv16e (QQGlobal.device);

		bbBuilder.writebytes (Tlvs.tlv144 (qq.TGTKey, tlv109, tlv124, tlv128, tlv16e));
		bbBuilder.writebytes (Tlvs.tlv142 (QQGlobal._apk_id));
		bbBuilder.writebytes (Tlvs.tlv145 (QQGlobal.imei_));
		bbBuilder.writebytes (Tlvs.tlv154 (RequestId));
		bbBuilder.writebytes (Tlvs.tlv141 (QQGlobal._network_type, QQGlobal._apn));
		bbBuilder.writebytes (Tlvs.tlv8 ());
		bbBuilder.writebytes (Tlvs.tlv16b ());
		bbBuilder.writebytes (Tlvs.tlv147 (QQGlobal._apk_v, QQGlobal._apk_sig))
		bbBuilder.writebytes (Tlvs.tlv177 ());
		bbBuilder.writebytes (Tlvs.tlv187 ());
		bbBuilder.writebytes (Tlvs.tlv188 ());
		bbBuilder.writebytes (Tlvs.tlv191 ());


		wupBuffer = pack.GetAll ();
		//' wupBuffer = ʮ�������ı����ֽڼ� (���ı��滻 (ɾȫ���� (_��������.�༭��3.����), #���з�, ����, , , ��))
		//' ������� (�ֽڼ���ʮ�������ı� (wupBuffer))
		wupBuffer = Pack_Pc (��08 10��, Hash.QQTEA (wupBuffer, qq.shareKey), qq.randKey, qq.pub_key)

		���� (Make_login_sendSsoMsg (��wtlogin.login��, wupBuffer, {  }, global.imei, qq._ksid, global.ver, ��))

	}
}
