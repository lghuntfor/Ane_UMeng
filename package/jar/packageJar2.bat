@echo off
::ת����ǰ�̷�
%~d0
::�򿪵�ǰĿ¼
cd %~dp0
::��������JAR����·��
set MainJar=umeng-analytics-v5.4.1.jar
::������JAR����·��
set ExternalJar=httpmime-4.1.3.jar
::������JAR������������
set packageName=org
echo =========== start combin ==============
::��ѹ��������
jar -xf %ExternalJar%
::�ϲ���JAR��
jar -uf %MainJar% %packageName% 
::������б�Ķ��������Խ��źϲ������磺
::jar -uf %MainJar% %packageName2%
::jar -uf %MainJar% org
::jar -uf %MainJar% cn
echo =========== over ==============
echo �ٵ�һ�¾ͽ�����--СQ
pause